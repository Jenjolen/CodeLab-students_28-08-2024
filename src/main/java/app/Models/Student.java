package app.Models;

import app.Models.Enums.CourseName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table (name = "student")
@NoArgsConstructor
@ToString
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "SELECT s from Student s"),
        @NamedQuery(name = "Student.findById", query = "select s from Student s where s.id = :id")
})
public class Student {

    private String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

    @Column
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "name")
   private String name;

    @Column (name = "phone_number")
   private String phonenumber;

    @Column (name = "email")
   private String email;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column (name = "address")
   private String address;

    @Column (name = "is_studying")
   private Boolean isStudying;

    @Column (name = "date_of_birth")
   private LocalDate dateOfBirth;

    @Column (name = "enrollment_date")
   private LocalDate enrollmentDate;

    @Column (name = "course_name")
    private CourseName courseName;

    public Student(String name, String phonenumber, String email, String address, Boolean isStudying, LocalDate dateOfBirth, LocalDate enrollmentDate, CourseName courseName) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
        this.isStudying = isStudying;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentDate = enrollmentDate;
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(getName(), student.getName()) && Objects.equals(getPhonenumber(), student.getPhonenumber()) && Objects.equals(getEmail(), student.getEmail()) && Objects.equals(getAddress(), student.getAddress()) && Objects.equals(getIsStudying(), student.getIsStudying()) && Objects.equals(getDateOfBirth(), student.getDateOfBirth()) && Objects.equals(getEnrollmentDate(), student.getEnrollmentDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhonenumber(), getEmail(), getAddress(), getIsStudying(), getDateOfBirth(), getEnrollmentDate());
    }

    @PrePersist
    public void prePersist() {
        if (this.email.matches(regex)){
        System.out.println("Persist: all good in the hood");
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        } else {
        System.out.println("Persist: go out with honor 🗡");
        throw new IllegalArgumentException("");
        }
    }

    @PreUpdate
    public void preUpdate() {
        if (this.email.matches(regex)){
            System.out.println("Update: all good in the hood");
            updatedAt = LocalDateTime.now();
        } else {
        System.out.println("Update: go out with honor 🗡");
        throw new IllegalArgumentException("");
        }
    }
}
