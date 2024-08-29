package app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class StudentDAOImpl implements GenericDAO<Student, Integer> {

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
        try(EntityManager em = emf.createEntityManager()) {
            Student deletedStudent = em.find(Student.class, id);
            em.getTransaction().begin();
            em.remove(deletedStudent);
            em.getTransaction().commit();
            return deletedStudent.getId();
        }
    }

    @Override
    public Student findEntity(Integer id) {
        try(EntityManager em = emf.createEntityManager()) {
            return em.find(Student.class, id);
        }
    }

    @Override
    public Student updateEntity(Student entity, Integer id) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Student updatedStudent = em.merge(entity);
            em.getTransaction().commit();
            return updatedStudent;
        }
    }



    @Override
    public List<Student> findAll() {
        try(EntityManager em = emf.createEntityManager()) {
            // var = variabel, Java finder selv ud af hvad returværdien skal være
//            return em.createQuery("from Student").getResultList();
            return em.createNamedQuery("Student.findAll", Student.class).getResultList();
        }
    }


    public Student findEntityByEmail(String email) {
        try(var em = emf.createEntityManager()) {
            return em.createNamedQuery("Student.findByEmail", Student.class)
                    .setParameter("email", email)
                    .getSingleResult();
        }
    }


}
