package com.fernando.basic.modules.courses.models.entities;

import com.fernando.basic.modules.students.models.entities.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToMany(mappedBy = "courses")
    Set<Student> students;

    @OneToMany(mappedBy = "course")
    Set<CourseRating> ratings;

    @OneToMany(mappedBy = "course")
    Set<CourseRegistration> registrations;
}