package com.bradescohbtn;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;

public class UsuarioOperations {
    public static void main(String[] args) {
        MongoDBConnection connection = new MongoDBConnection();
        MongoDatabase database = connection.getDatabase();

        if (database == null) {
            System.err.println("Falha na conexão com o banco de dados.");
            return;
        }

        MongoCollection<Document> collection = database.getCollection("usuarios");

        // Limpar coleção antes dos testes
        collection.drop();

        // Inserir registros
        Usuario u1 = new Usuario("Alice", 25);
        Usuario u2 = new Usuario("Bob", 30);
        Usuario u3 = new Usuario("Charlie", 35);

        collection.insertMany(Arrays.asList(u1.toDocument(), u2.toDocument(), u3.toDocument()));
        System.out.println("\n== Registros inseridos ==");
        listar(collection);

        // Atualizar idade de Bob
        collection.updateOne(eq("nome", "Bob"), new Document("$set", new Document("idade", 32)));
        System.out.println("\n== Bob atualizado ==");
        listar(collection);

        // Deletar Charlie
        collection.deleteOne(eq("nome", "Charlie"));
        System.out.println("\n== Charlie removido ==");
        listar(collection);

        connection.closeConnection();
    }

    private static void listar(MongoCollection<Document> collection) {
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Usuario usuario = Usuario.fromDocument(doc);
                System.out.println(usuario);
            }
        }
    }
}
