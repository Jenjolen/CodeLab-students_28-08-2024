package app.Models;

import app.Models.Enums.CourseName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.joda.time.DateTime;

import java.util.Objects;

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
    @Enumerated(EnumType.STRING)
    private CourseName name;

    @Column(name = "course_teacher",nullable = false)
    private String teacher; //TODO: change "String" to class "Person" once we have access to it

    @Column(name = "course_semester", nullable = false)
    private int semester;

    @Column(name = "course_classroom",nullable = false)
    private String classroom;

    @Column(name = "course_time", nullable = false)
    private DateTime timeOfCourse;

    public Course(CourseName name, String teacher, int semester, String classroom, DateTime timeOfCourse) {
        this.name = name;
        this.teacher = teacher;
        this.semester = semester;
        this.classroom = classroom;
        this.timeOfCourse = timeOfCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return semester == course.semester && name == course.name && Objects.equals(teacher, course.teacher) && Objects.equals(classroom, course.classroom) && Objects.equals(timeOfCourse, course.timeOfCourse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teacher, semester, classroom, timeOfCourse);
    }
}
