package app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =HibernateConfig.getEntityManagerFactoryConfig(false);
        EntityManager em = emf.createEntityManager();

        StudentDAOImpl studentDAO =StudentDAOImpl.getInstance(emf);
        Student student = new Student("jen", "1234", "kmjioj", "vej", true, LocalDate.of(2002, 11, 7), LocalDate.of(2022, 8, 24));
        studentDAO.saveEntity(student);

        student.setIsStudying(false);
        studentDAO.updateEntity(student, student.getId());



    }
}