package com.alvan.springbasis.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

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

	public void deleteStudent(Long studentId) {
		Boolean exists = studentRepository.existsById(studentId);
		if(!exists){
			throw new IllegalStateException("Student with the id:" + studentId + " Does not exist");
		}
		studentRepository.deleteById(studentId);
	}

	@Transactional
	public void updateStudent(Long studentId, String email, String name) {
		Student student = studentRepository.findById(studentId).orElseThrow(()-> new IllegalStateException("Student with the id:" + studentId + " Does not exist"));

		if(name != null && name.length() > 0 && !Objects.equals(student.getName(),name)){
			student.setName(name);
		}

		if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
			Optional<Student> studentOptional = studentRepository.findStudentByEmaial(email);
			if(studentOptional.isPresent()){
				throw new IllegalStateException("Email is taken");

			}
			student.setEmail(email);
		}
		
	} 
}
