package app;

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
public class Student {

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

    @Column (name = "address")
   private String address;

    @Column (name = "is_studying")
   private Boolean isStudying;

    @Column (name = "date_of_birth")
   private LocalDate dateOfBirth;

    @Column (name = "enrollment_date")
   private LocalDate enrollmentDate;

    @Column (name = "created_at")
    private LocalDateTime createdAt;

    @Column (name = "updated_id")
    private LocalDateTime updatedAt;


    public Student(String name, String phonenumber, String email, String address, Boolean isStudying, LocalDate dateOfBirth, LocalDate enrollmentDate) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
        this.isStudying = isStudying;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentDate = enrollmentDate;
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
    private void ifYouPersist() { // når vi kalder saveEntity metoden fra StudentDAO
        System.out.println("Before the update");
    }

    @PreUpdate
   private void ifYouUpdate() { // nr vi kalder updateEntity metodne fra StudentDAO
        System.out.println("All new and freshly updated");
    }


}
