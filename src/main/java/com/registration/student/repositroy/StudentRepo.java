package com.registration.student.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.student.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
