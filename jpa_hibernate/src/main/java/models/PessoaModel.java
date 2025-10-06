package models;

import entities.Pessoa;
import javax.persistence.*;
import java.util.List;

public class PessoaModel {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");

    public void create(Pessoa pessoa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao criar pessoa: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Pessoa findById(int id) {
        EntityManager em = emf.createEntityManager();
        Pessoa pessoa = null;
        try {
            pessoa = em.find(Pessoa.class, id);
        } catch (Exception e) {
            System.err.println("Erro ao buscar pessoa: " + e.getMessage());
        } finally {
            em.close();
        }
        return pessoa;
    }

    @SuppressWarnings("unchecked")
    public List<Pessoa> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Pessoa> pessoas = null;
        try {
            pessoas = em.createQuery("FROM Pessoa").getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao listar pessoas: " + e.getMessage());
        } finally {
            em.close();
        }
        return pessoas;
    }

    public void update(Pessoa pessoa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(pessoa);
            em.getTransaction().commit();
            System.out.println("Pessoa atualizada com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao atualizar pessoa: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Pessoa pessoa = em.find(Pessoa.class, id);
            if (pessoa != null) {
                em.getTransaction().begin();
                em.remove(pessoa);
                em.getTransaction().commit();
                System.out.println("Pessoa removida com sucesso!");
            } else {
                System.out.println("Pessoa não encontrada para exclusão.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao remover pessoa: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
