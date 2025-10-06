package models;

import entities.Produto;
import javax.persistence.*;
import java.util.List;

public class ProdutoModel {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");

    public void create(Produto produto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao criar produto: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Produto findById(int id) {
        EntityManager em = emf.createEntityManager();
        Produto produto = null;
        try {
            produto = em.find(Produto.class, id);
        } catch (Exception e) {
            System.err.println("Erro ao buscar produto: " + e.getMessage());
        } finally {
            em.close();
        }
        return produto;
    }

    @SuppressWarnings("unchecked")
    public List<Produto> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Produto> produtos = null;
        try {
            produtos = em.createQuery("FROM Produto").getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        } finally {
            em.close();
        }
        return produtos;
    }

    public void update(Produto produto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
            System.out.println("Produto atualizado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Produto produto = em.find(Produto.class, id);
            if (produto != null) {
                em.getTransaction().begin();
                em.remove(produto);
                em.getTransaction().commit();
                System.out.println("Produto removido com sucesso!");
            } else {
                System.out.println("Produto não encontrado para exclusão.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao remover produto: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
