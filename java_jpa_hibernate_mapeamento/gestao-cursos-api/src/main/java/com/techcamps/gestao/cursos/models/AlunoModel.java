package com.techcamps.gestao.cursos.models;

import com.techcamps.gestao.cursos.entities.Aluno;
import javax.persistence.*;
import java.util.List;

public class AlunoModel {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao criar aluno: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public Aluno findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Aluno a = em.find(Aluno.class, id);
        em.close();
        return a;
    }

    public List<Aluno> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Aluno> list = em.createQuery("FROM Aluno", Aluno.class).getResultList();
        em.close();
        return list;
    }

    public void update(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno atualizado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao atualizar aluno: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Aluno a = em.find(Aluno.class, id);
            if (a != null) {
                em.getTransaction().begin();
                em.remove(a);
                em.getTransaction().commit();
                System.out.println("Aluno removido com sucesso!");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Erro ao remover aluno: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
