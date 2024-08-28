package app;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

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




}
