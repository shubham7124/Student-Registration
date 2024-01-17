package com.registration.student.services;

import java.util.List;

import com.registration.student.entity.Student;

public interface StudentServices {

	Student createStudent(Student student);
	Student updateStudent(int id ,Student student);
	void deleteStudent(int id);
	List<Student> getAllStudent();
	Student getStudentById(int id);
	
	
}
