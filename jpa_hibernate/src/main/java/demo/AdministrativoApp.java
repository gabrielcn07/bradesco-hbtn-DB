package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

public class AdministrativoApp {
    public static void main(String[] args) {
        System.out.println("=== Sistema Administrativo Iniciado ===");

        PessoaModel pessoaModel = new PessoaModel();
        ProdutoModel produtoModel = new ProdutoModel();

        Pessoa p = new Pessoa("Gabriel Nunes", "gabriel@email.com", 28, "123.456.789-00", "1997-05-12");
        pessoaModel.save(p);

        Produto prod = new Produto("Notebook", 10, 4200.0, true);
        produtoModel.save(prod);

        System.out.println("Pessoa e produto adicionados com sucesso!");
    }
}
