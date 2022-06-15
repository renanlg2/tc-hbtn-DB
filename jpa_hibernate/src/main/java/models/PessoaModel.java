package models;

import entities.Pessoa;
import util.GetEntityManager;

import javax.persistence.EntityManager;
import java.util.List;

public class PessoaModel {

    private EntityManager em = GetEntityManager.getEntityManager();

    public void create(Pessoa p) {
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao criar a pessoa !!!" + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            System.out.println("Finalizando a transação");
        }

    }

    public void update(Pessoa p) {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Pessoa atualizada com sucesso");
        } catch (Exception e) {
            System.out.println("Falha ao atualizar a pessoa !!!" + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Pessoa p) {
        Pessoa pessoaTemp = this.findById(p);
        try {
            em.getTransaction().begin();
            em.remove(pessoaTemp);
            em.getTransaction().commit();
            System.out.println("Pessoa deletada com sucesso");
        } catch (Exception e){
            System.out.println("Falha ao deletar a pessoa !!! " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public Pessoa findById(Pessoa p) {
        Pessoa pessoaTemp = null;

        try {
            pessoaTemp = em.find(Pessoa.class, p.getId());
        } catch (Exception e){
            System.out.println("Falha ao encontrar a pessoa por ID !!! " + e.getMessage());
        } finally {
            System.out.println("Finalizando a transação");
        }

        return pessoaTemp;
    }

    public List<Pessoa> findAll() {
        return em.createQuery("FROM " + Pessoa.class.getSimpleName()).getResultList();
    }

}
