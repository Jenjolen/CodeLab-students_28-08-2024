package app;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.joda.time.DateTime;

@Entity
@NoArgsConstructor
@Table(name = "courses")
@Getter
@Setter
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private int id;

    @Column(name = "course_name", nullable = false)
    private String name;

    @Column(name = "course_teacher",nullable = false)
    private String teacher; //TODO: change "String" to class "Person" once we have access to it

    @Column(name = "course_semester", nullable = false)
    private int semester;

    @Column(name = "course_classroom",nullable = false)
    private String classroom;

    @Column(name = "course_time", nullable = false)
    private DateTime timeOfCourse;

    public Course(String name, String teacher, int semester, String classroom, DateTime timeOfCourse) {
        this.name = name;
        this.teacher = teacher;
        this.semester = semester;
        this.classroom = classroom;
        this.timeOfCourse = timeOfCourse;
    }
}
