package app;

import app.DAOs.StudentDAOImpl;
import app.Models.Student;
import app.Config.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig(false);
        EntityManager em = emf.createEntityManager();

        StudentDAOImpl dao = StudentDAOImpl.getInstance(emf);
        Student testSubject = new Student("Jearnevios", "12345678", "skibidi@toilet.com", "gamer st.", true, LocalDate.now(), LocalDate.now());
        dao.saveEntity(testSubject);
        testSubject.setEmail("gamermailcom");
        dao.updateEntity(testSubject,1);

    }
}