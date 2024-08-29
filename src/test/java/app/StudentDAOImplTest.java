package app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOImplTest {

    private static StudentDAOImpl dao;
    private static EntityManagerFactory emf;


    private Student student1 = new Student("Patrick", "112", "p@tada", "campus", true, LocalDate.of(1995, 11, 4), LocalDate.of(2023, 8, 26));
    private Student student2 = new Student("William", "145", "okpokok", "rytterknægten", true, LocalDate.of(1941, 9, 8), LocalDate.of(2023, 10, 28));
    private Student student3 = new Student("Anna", "7589", "1234@com", "strandvejen", true, LocalDate.of(1995, 11, 4), LocalDate.of(2023, 8, 26));
    private Student student4 = new Student("Pa", "112", "p@tada8", "campus", true, LocalDate.of(1995, 12, 4), LocalDate.of(2023, 10, 28));
    private Student student5 = new Student("Da", "112", "p@tada2", "campus", true, LocalDate.of(1995, 12, 4), LocalDate.of(2023, 8, 26));

    @BeforeAll
    static void setUpAll() {
        emf = HibernateConfig.getEntityManagerFactoryConfig(true);
        dao = StudentDAOImpl.getInstance(emf);


    }

    @BeforeEach
    void setUp() {
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Student").executeUpdate();
            em.persist(student1);
            em.persist(student2);
            em.persist(student3);
            em.persist(student4);
            em.persist(student5);
            em.getTransaction().commit();
        }
    }

    @Test
    void saveEntity() {
        EntityManager em = emf.createEntityManager();
        Student test = new Student("Patrick2", "1123", "p@tada", "campus", true, LocalDate.of(1995, 11, 5), LocalDate.of(2023, 8, 26));

        dao.saveEntity(test);
        Student retrievedStudent = em.find(Student.class, test.getId());
        assertEquals(test, retrievedStudent);
    }


//    @Test
//    void persistAndUpdate() {
//
//        student1.ifYouPersist();
//        student2.ifYouUpdate();
//    }


}