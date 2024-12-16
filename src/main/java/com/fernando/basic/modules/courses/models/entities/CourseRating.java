package com.fernando.basic.modules.courses.models.entities;

import com.fernando.basic.modules.students.models.entities.Student;
import jakarta.persistence.*;

@Entity
public class CourseRating {

    @EmbeddedId
    private CourseRatingKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;

    int rating;

}
