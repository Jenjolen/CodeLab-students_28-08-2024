package app;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class CourseDAO implements GenericDAO<Course, Integer> {

    private static CourseDAO instance;
    private static EntityManagerFactory emf;

    public static CourseDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CourseDAO();
        }
        return instance;
    }

    @Override
    public void saveEntity(Course entity) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }
    }

    @Override
    public int deleteEntity(Integer id) {
        try(EntityManager em = emf.createEntityManager()) {
            Course deletedCourse = em.find(Course.class, id);
            em.getTransaction().begin();
            em.remove(deletedCourse);
            em.getTransaction().commit();
            return deletedCourse.getId();
        }
    }

    @Override
    public Course findEntity(Integer id) {
        try(EntityManager em = emf.createEntityManager()) {
                return em.find(Course.class, id);
        }
    }

    @Override
    public Course updateEntity(Course entity, Integer id) {
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Course updatedCourse = em.merge(entity);
            em.getTransaction().commit();
            return updatedCourse;
        }
    }

    @Override
    public List<Course> findAll() {
        try(EntityManager em = emf.createEntityManager()) {
            return em.createQuery("from Course").getResultList();
        }
    }



//public List<Student> getAllStudentsFromCourse(CourseName course) {
//    try(EntityManager em = emf.createEntityManager()){
//        return em.createQuery("from Student s where s.courseName = :courseName", Student.class)
//                .setParameter("courseName", course)
//                .getResultList();
//    }



}
