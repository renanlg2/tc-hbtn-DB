package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GetEntityManager {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    public static EntityManager getEntityManager(){
        emf = Persistence.createEntityManagerFactory("admin-jpa");
        em = emf.createEntityManager();
        return em;
    }

    public static void closeEntityManager(){
        em.close();
        emf.close();
    }
}
