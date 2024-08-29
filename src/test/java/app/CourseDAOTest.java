package app;

import app.DAOs.CourseDAO;
import app.Models.Course;
import app.Models.Enums.CourseName;
import app.Config.HibernateConfig;
import jakarta.persistence.EntityManagerFactory;
import org.joda.time.DateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseDAOTest {

    private static EntityManagerFactory emf;
    private static CourseDAO dao;

    Course tc1 = new Course(CourseName.MATH,"teacher1",1,"room1",DateTime.now());
    Course tc2 = new Course(CourseName.ENGLISH,"teacher2",2,"room2",DateTime.now());
    Course tc3 = new Course(CourseName.ART,"teacher3",3,"room3",DateTime.now());
    Course tc4 = new Course(CourseName.MUSIC,"teacher4",4,"room4",DateTime.now());

    @BeforeAll
    static void setUpBA() {
        emf = HibernateConfig.getEntityManagerFactoryConfig(true);
        dao = CourseDAO.getInstance(emf);
    }

    @BeforeEach
    void setUpBE() {
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.createQuery("delete from Course").executeUpdate();
            em.persist(tc1);
            em.persist(tc2);
            em.persist(tc3);
            em.persist(tc4);
            em.getTransaction().commit();
        }
    }

//    @Test
    void saveEntity() { //don't really knwo hwo to test this, since it is a void method
        Course testCourse = new Course(CourseName.HISTORY,"l",3,"rum",DateTime.now());
        dao.saveEntity(testCourse);
    }

    @Test
    void deleteEntity() {

        int expectedId = 1;

        int actualId = dao.deleteEntity(tc1.getId());

        assertEquals(expectedId, actualId);
    }

    @Test
    void findEntity() {
        Course expectedCourse = tc2;

        Course actualCourse = dao.findEntity(2);

        assertEquals(expectedCourse.getId(), actualCourse.getId());

    }


    @Test
    void updateEntity() {

        Course unmodifiedCourse = dao.findEntity(3);
        Course modifiedCourse = dao.findEntity(3);
        modifiedCourse.setTeacher("Bob");

        dao.updateEntity(modifiedCourse,3);

        assertNotEquals(unmodifiedCourse.getTeacher(), modifiedCourse.getTeacher());
    }

//    @Test
    void findAll() {
        dao.findAll();
    }

}