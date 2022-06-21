package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AlunoModel {


    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Aluno aluno){
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null)
                em.getTransaction().rollback();

            e.printStackTrace();
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
        } finally {
            if (em != null)
                em.close();

            System.out.println("Finalizando transacao criacao Aluno ...");
        }
    }

    public void update(Aluno aluno){
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
        } catch (Exception e){
            if (em != null)
                em.getTransaction().rollback();

            e.printStackTrace();
            System.out.println("Erro ao atualizar aluno: " + e.getMessage());
        } finally {
            if (em != null)
                em.close();

            System.out.println("Finalizando transacao atualizacao Aluno ...");
        }
    }

    public void delete(Aluno aluno){
        EntityManager em = null;
        Aluno alunoTemp = findById(aluno);

        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.remove(alunoTemp);
            em.getTransaction().commit();
        } catch (Exception e){
            if (em != null)
                em.getTransaction().rollback();

            e.printStackTrace();
            System.out.println("Erro ao deletar aluno: " + e.getMessage());
        } finally {
            if (em != null)
                em.close();

            System.out.println("Finalizando transacao delete Aluno ...");
        }
    }

    public Aluno findById(Aluno aluno){
        EntityManager em = null;
        Aluno alunoTemp = null;

        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            alunoTemp = em.find(Aluno.class, aluno.getId());
            em.getTransaction().commit();
        } catch (Exception e){
            if (em != null)
                em.getTransaction().rollback();

            e.printStackTrace();
            System.out.println("Erro ao encontrar o aluno por ID ! " + e.getMessage());
        }
        finally {
            if (em != null)
                em.close();

            System.out.println("Finalizando transacao findById Aluno ...");
        }

        return alunoTemp;
    }

    public List<Aluno> findAll(){
        EntityManager em = null;
        List<Aluno> listaAlunos = new ArrayList<>();

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            listaAlunos = em.createQuery("FROM " + Aluno.class.getSimpleName()).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null)
                em.getTransaction().rollback();

            System.out.println("Erro ao buscar todos os alunos: " + e.getMessage());
        } finally {
            if (em != null)
                em.close();

            System.out.println("Finalizando transacao findAll Aluno ...");
        }

        return listaAlunos;
    }
}
