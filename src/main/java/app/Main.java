package app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.joda.time.DateTime;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =HibernateConfig.getEntityManagerFactoryConfig(false);
        EntityManager em = emf.createEntityManager();

        StudentDAOImpl studentDAO =StudentDAOImpl.getInstance(emf);
        Student student = new Student("jen", "1234", "kmj@ioj", "vej", true, LocalDate.of(2002, 11, 7), LocalDate.of(2022, 8, 24));
        studentDAO.saveEntity(student);

        student.setEmail("ffjn@");
        studentDAO.updateEntity(student, student.getId());


        CourseDAO courseDAO = CourseDAO.getInstance(emf);
        courseDAO.saveEntity(new Course(CourseName.MUSIC, "Mrs. Jones", 3, "K.101", DateTime.parse("2022-11-22")));



    }
}