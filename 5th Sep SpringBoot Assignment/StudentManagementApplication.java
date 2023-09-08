package com.gainsight.StudentManagement;

import com.gainsight.StudentManagement.entity.Course;
import com.gainsight.StudentManagement.entity.Student;
import com.gainsight.StudentManagement.repository.CourseRepository;
import com.gainsight.StudentManagement.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.gainsight.StudentManagement.service.CourseService;

import java.util.Optional;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(StudentManagementApplication.class, args);

		CourseService courseService = container.getBean(CourseService.class);
		Course course = courseService.findCourseById(1);

		System.out.println(course.getCourseId()+" "+course.getCourseName());

		for (Student s : course.getStudents()) {
			System.out.println(s.getStudentId()+" "+s.getStudentName()+" "+s.getPhoneNum());

		}

		StudentService studentService=container.getBean(StudentService.class);

		Student student=studentService.findStudentById(2);
		System.out.println(student.getStudentName() );

		for(Course c:student.getCourses()) {
			System.out.println(c.getCourseName());
		}
		courseService.addCourseToStudentById(1,1);

	}
}
