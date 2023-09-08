package com.gainsight.StudentManagement.repository;

import com.gainsight.StudentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllByStudentId(int id);
}
