package com.fernando.basic.modules.students.models.entities;

import com.fernando.basic.modules.courses.models.entities.Course;
import com.fernando.basic.modules.courses.models.entities.CourseRating;
import com.fernando.basic.modules.courses.models.entities.CourseRegistration;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Student {

    @Id
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="tb_students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

    @OneToMany(mappedBy = "student")
    Set<CourseRating> ratings;

    @OneToMany(mappedBy = "student")
    Set<CourseRegistration> registrations;

}