package app;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

@Entity
@NoArgsConstructor
@Table(name = "courses")
@Getter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int id;

    @Column(name = "course_name")
    private String name;

    @Column(name = "course_teacher")
    private String teacher; //TODO: change "String" to class "Person" once we have access to it

    @Column(name = "course_semester")
    private int semester;

    @Column(name = "course_classroom")
    private String classroom;

    @Column(name = "course_time")
    private DateTime timeOfCourse;
}
