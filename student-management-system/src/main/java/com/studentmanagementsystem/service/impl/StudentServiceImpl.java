package com.studentmanagementsystem.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.repository.StudentRepository;
import com.studentmanagementsystem.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	//As we are using Constructor based dependency Injection
	
	//So instead of @Autowired we are mentioning the constructor 
	
	private StudentRepository studentRepository;
	
	
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}



	@Override
	public List<Student> getAllStudents() {
		
		//So the StudentRepository has all the CRUD methods
		
		return studentRepository.findAll();
	}



	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}



	@Override
	public Student getStudentById(Long id) {
		
		return studentRepository.findById(id).get();
	}



	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}



	@Override
	public void deleteStudentById(Long id) {
		
	studentRepository.deleteById(id);;
		 
	}

	
}
