package app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class StudentDAOImpl implements GenericDAO <Student, Integer> {

    private static StudentDAOImpl instance;
    private static EntityManagerFactory emf;


    public static StudentDAOImpl getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new StudentDAOImpl();
        }
        return instance;

    }

    @Override
    public void saveEntity(Student entity) {
        EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
    em.close();


    }


    @Override
    public int deleteEntity(Integer id) {
        return 0;
    }

    @Override
    public Student findEntity(Integer id) {
        return null;
    }

    @Override
    public Student updateEntity(Student entity, Integer id) {
        return null;
    }
}
