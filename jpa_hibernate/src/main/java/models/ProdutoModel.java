package models;

import entities.Produto;
import javax.persistence.*;

public class ProdutoModel {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");

    public void save(Produto produto) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(produto);
        em.getTransaction().commit();
        em.close();
    }
}
