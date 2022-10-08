package com.alvan.springbasis.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public List<Student> getStudents(){
		return List.of(
			new Student(1L, "alvan", LocalDate.of(2000,Month.APRIL,22), "alvan", 22)
		);
	} 
}
