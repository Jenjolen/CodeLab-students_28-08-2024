package app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =HibernateConfig.getEntityManagerFactoryConfig(false);
        EntityManager em = emf.createEntityManager();

    }
}