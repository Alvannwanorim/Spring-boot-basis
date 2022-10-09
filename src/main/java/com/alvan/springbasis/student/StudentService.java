package com.alvan.springbasis.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

    public List<Student> getStudents(){
		return studentRepository.findAll();
	}

	public void createNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository.findStudentByEmaial(student.getEmail());
		if(studentOptional.isPresent()){
			throw new IllegalStateException("Email already exists");
		}
		studentRepository.save(student);
	} 
}
