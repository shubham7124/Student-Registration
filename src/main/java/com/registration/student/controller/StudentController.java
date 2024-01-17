package com.registration.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.student.entity.Student;
import com.registration.student.serviceImp.StudentServiceImpl;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentServiceImpl serviceImpl;

	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {

		Student newStudent = this.serviceImpl.createStudent(student);

		return new ResponseEntity<Student>(newStudent, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudent() {

		List<Student> student = this.serviceImpl.getAllStudent();

		return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseNotFound> deleteStudent(@PathVariable int id) {
		this.serviceImpl.deleteStudent(id);
		return new ResponseEntity<ResponseNotFound>(new ResponseNotFound("Deleted Successfully", true), HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Student> getSingleStudent(@PathVariable int id) {
		Student student = this.serviceImpl.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> upateOldStudent(@Valid @PathVariable int id, @RequestBody Student student)
	{
		Student updatedStudent=this.serviceImpl.updateStudent(id, student);
		
		return new ResponseEntity<Student>(updatedStudent,HttpStatus.OK);
	}
}
