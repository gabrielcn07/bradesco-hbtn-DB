package com.techcamps.gestao.cursos.models;

import com.techcamps.gestao.cursos.entities.Curso;
import javax.persistence.*;
import java.util.List;

public class CursoModel {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Curso curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("Curso criado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao criar curso: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Curso findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Curso c = em.find(Curso.class, id);
        em.close();
        return c;
    }

    public java.util.List<Curso> findAll() {
        EntityManager em = emf.createEntityManager();
        java.util.List<Curso> list = em.createQuery("FROM Curso", Curso.class).getResultList();
        em.close();
        return list;
    }

    public void update(Curso curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
            System.out.println("Curso atualizado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao atualizar curso: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Curso c = em.find(Curso.class, id);
            if (c != null) {
                em.getTransaction().begin();
                em.remove(c);
                em.getTransaction().commit();
                System.out.println("Curso removido com sucesso!");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao remover curso: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
