package com.gainsight.StudentManagement.service;


import com.gainsight.StudentManagement.entity.Course;
import com.gainsight.StudentManagement.entity.Student;
import com.gainsight.StudentManagement.repository.CourseRepository;
import com.gainsight.StudentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student findStudentById(int id){
        Optional<Student> opStudent= studentRepository.findById(id);
        if(opStudent.isPresent())
            return opStudent.get();
        throw new RuntimeException("Student object not exist with no "+id);
    }
    public List<Student> findAllByStudentId(int id){
        List<Student> student= studentRepository.findAllByStudentId(id);
        return student;
    }

}
