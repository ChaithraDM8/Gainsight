package com.gainsight.StudentManagement.service;

import com.gainsight.StudentManagement.entity.Course;
import com.gainsight.StudentManagement.entity.Student;
import com.gainsight.StudentManagement.repository.CourseRepository;
import com.gainsight.StudentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepo;
    @Autowired
    StudentRepository studentRepository;
    public Course findCourseById(int id){
        Optional<Course> opCourse= courseRepo.findById(id);
         if(opCourse.isPresent())
            return opCourse.get();
        throw new RuntimeException("Course object not exist with no "+id);
    }

    public List<Course> findAllByCourseId(int id){
        List<Course> courses= courseRepo.findAllByCourseId(id);
        return courses;
    }
    public void addCourseToStudentById(int courseId,int studentId){
        Student student=studentRepository.findById(studentId).get();
        Course course=findCourseById(courseId);
        course.enrollCourseToStudent(student);
        studentRepository.save(student);
    }
}
