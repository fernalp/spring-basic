package com.fernando.basic.modules.courses.models.entities;

import com.fernando.basic.modules.students.models.entities.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class CourseRegistration {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDateTime registeredAt;

    private Integer grade;
}
