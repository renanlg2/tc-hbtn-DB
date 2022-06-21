package models;

import entities.Curso;
import entities.Professor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class CursoModel {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Curso curso){
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null)
                em.getTransaction().rollback();

            e.printStackTrace();
            System.out.println("Erro ao cadastrar curso: " + e.getMessage());
        } finally {
            if (em != null)
                em.close();

            System.out.println("Finalizando transacao criacao Curso ...");
        }
    }

    public void update(Curso curso){
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception e){
            if (em != null)
                em.getTransaction().rollback();

            e.printStackTrace();
            System.out.println("Erro ao atualizar curso: " + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando transacao atualizacao Curso ...");
        }
    }

    public void updateProfessor(Professor professor){
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(professor);
            em.getTransaction().commit();
        } catch (Exception e){
            if (em != null)
                em.getTransaction().rollback();

            e.printStackTrace();
            System.out.println("Erro ao atualizar professor: " + e.getMessage());
        } finally {
            if (em != null)
                em.close();

            System.out.println("Finalizando transacao atualizacao Professor ...");
        }
    }

    public void delete(Curso curso){
        EntityManager em = null;
        Curso cursoTemp = null;

        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            cursoTemp = em.find(Curso.class, curso.getId());
            em.remove(cursoTemp);
            em.getTransaction().commit();
        } catch (Exception e){
            if (em != null)
                em.getTransaction().rollback();

            e.printStackTrace();
            System.out.println("Erro ao deletar curso: " + e.getMessage());
        } finally {
            if (em != null)
                em.close();

            System.out.println("Finalizando transacao delete Curso ...");
        }
    }

    public void deleteProfessor(Professor professor){
        EntityManager em = null;
        Professor professorTemp = null;

        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            professorTemp = em.find(Professor.class, professor.getId());
            System.out.println("Professor a ser apagado: " + professorTemp);
            em.remove(professorTemp);
            em.getTransaction().commit();
        } catch (Exception e){
            if (em != null)
                em.getTransaction().rollback();

            e.printStackTrace();
            System.out.println("Erro ao deletar professor: " + e.getMessage());
        } finally {
            if (em != null)
                em.close();

            System.out.println("Finalizando transacao delete Professor ...");
        }
    }

    public Curso findCursoById(Curso curso){
        EntityManager em = null;
        Curso cursoTemp = null;

        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            cursoTemp = em.find(Curso.class, curso.getId());
            em.getTransaction().commit();
        } catch (Exception e){
            if (em != null)
                em.getTransaction().rollback();

            e.printStackTrace();
            System.out.println("Erro ao encontrar o curs por ID ! " + e.getMessage());
        }
        finally {
            if (em != null)
                em.close();

            System.out.println("Finalizando transacao findById Curso ...");
        }

        return cursoTemp;
    }

    public Professor findProfessorById(Professor professor){
        EntityManager em = null;
        Professor professorTemp = null;

        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            professorTemp = em.find(Professor.class, professor.getId());
            em.getTransaction().commit();
        } catch (Exception e){
            if (em != null)
                em.getTransaction().rollback();

            e.printStackTrace();
            System.out.println("Erro ao encontrar o professor por ID ! " + e.getMessage());
        }
        finally {
            if (em != null)
                em.close();

            System.out.println("Finalizando transacao findById Professor ...");
        }

        return professorTemp;
    }

    public List<Curso> findAll(){
        EntityManager em = null;
        List<Curso> listaCursos = new ArrayList<>();

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            listaCursos.addAll(em.createQuery("FROM " + Curso.class.getSimpleName()).getResultList());
            em.getTransaction().commit();
        } catch (Exception e){
            if (em != null)
                em.getTransaction().rollback();

            System.out.println("Erro ao buscar todos os alunos: " + e.getMessage());

        } finally {
            if (em != null)
                em.close();

            System.out.println("Finalizando transacao findAll Curso ...");
        }

        return listaCursos;
    }

    public List<Professor> findAllProfessor() {
        EntityManager em = null;
        List<Professor> listaProfessores = new ArrayList<>();

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            listaProfessores = em.createQuery("FROM " + Professor.class.getSimpleName()).getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em != null)
                em.getTransaction().rollback();

            System.out.println("Erro ao buscar todos os professores: " + e.getMessage());
        } finally {
            if (em != null)
                em.close();

            System.out.println("Finalizando transacao findAll Professor ...");
        }

        return listaProfessores;
    }
}
