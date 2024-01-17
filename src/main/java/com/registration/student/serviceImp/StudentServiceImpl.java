package com.registration.student.serviceImp;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.registration.student.controller.ResponseNotFound;
import com.registration.student.entity.Student;
import com.registration.student.repositroy.StudentRepo;
import com.registration.student.services.StudentServices;

@Service
public class StudentServiceImpl implements StudentServices {
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		Student newStudent=this.studentRepo.save(student);
		return newStudent;
	}

	@Override
	public Student updateStudent(int id, Student student) {
		// TODO Auto-generated method stub
		Student oldStudent=this.studentRepo.findById(id).orElseThrow(()-> new NoSuchFieldError("Student not exists:"+id));
		oldStudent.setFirstName(student.getFirstName());
		oldStudent.setLastName(student.getLastName());
		oldStudent.setAddress(student.getAddress());
		oldStudent.setAge(student.getAge());
		oldStudent.setGender(student.getGender());
		
		Student newStudent=this.studentRepo.save(oldStudent);
		
		return newStudent;
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
	    Student user = this.studentRepo.findById(id).orElseThrow(() -> new NoSuchFieldError("User not found:"+id));
	    this.studentRepo.delete(user);
	    

		
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> student=this.studentRepo.findAll();
		return student;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
	   Student student=this.studentRepo.findById(id).orElseThrow(()-> new NoSuchFieldError("Student not Exitst:"+id));
		return student;
	}

}
