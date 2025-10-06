package models;

import entities.Pessoa;
import javax.persistence.*;

public class PessoaModel {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");

    public void save(Pessoa pessoa) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();
        em.close();
    }
}
