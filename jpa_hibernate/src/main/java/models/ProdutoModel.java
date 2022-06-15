package models;

import entities.Produto;
import util.GetEntityManager;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoModel {
    private EntityManager em;

    public ProdutoModel() {
        em = GetEntityManager.getEntityManager();
    }

    public void create(Produto p) {
        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            System.out.println("Falha ao criar o produto !!!" + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Produto p) {
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Produto atualizado com sucesso !!!");
        } catch (Exception e) {
            System.out.println("Falha ao atualizar o produto !!!" + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Produto p) {
        Produto produtoTemp = this.findById(p);
        try {
            em.getTransaction().begin();
            em.remove(produtoTemp);
            em.getTransaction().commit();
            System.out.println("Produto deletado com sucesso");
        } catch (Exception e){
            System.out.println("Falha ao deletar o produto !!! " + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            System.out.println("Finalizando a transação");
        }
    }

    public Produto findById(Produto p) {
        Produto produtoTemp = null;

        try {
            produtoTemp = em.find(Produto.class, p.getId());
        } catch (Exception e) {
            System.out.println("Falha ao encontrar o produto por ID !!! " + e.getMessage());
        } finally {
            System.out.println("Finalizando transação");
        }

        return produtoTemp;
    }

    public List<Produto> findAll() {
        return em.createQuery("FROM " + Produto.class.getSimpleName()).getResultList();
    }
}
