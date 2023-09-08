package com.gainsight.StudentManagement.repository;

import com.gainsight.StudentManagement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course> findAllByCourseId(int id);
}
