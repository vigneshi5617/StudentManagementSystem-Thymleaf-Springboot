package com.studentmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentmanagementsystem.entity.Student;
import com.studentmanagementsystem.service.StudentService;

//We add this annotation to make this as SpringMvc class to handle the request coming around

@Controller
public class StudentController {

	//We are using Constructor based depencdy Injection
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	//Handler method to handle list students and return model and view
	//Make sure we import Model from org.springframework
	//Model is added as attribute to method
	@GetMapping("/students")
	public String listStudents(Model model ) {
		model.addAttribute("students",studentService.getAllStudents());
		
		
		return "students";
		//After giving the "view " above lets create it
		//So Sprinboot has to configure ViewResolver for Thymleaf, we dont need to manually configure a bean for thymleaf ,Spring boot takes care of that.
		//So Springboot will automatically configure a ViewResolver for Thyleadf whn its sees its depencdncy in pom.xml.
		
		// So the return is "View-->students" and the model returns a "ListofAllStudents" and we display that in students.html
		
		
		
		
	}
	
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		//create student object to hold student form data
		Student student =new Student();
	
		model.addAttribute("student",student);
		
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		
		studentService.saveStudent(student);
		
		return "redirect:/students"; //GO to above method is what we are mentioning here 
		
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		
		model.addAttribute("student",studentService.getStudentById(id));
		
		
		return "edit_student";
		
		
		
		
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id ,
			@ModelAttribute("student") Student student ,Model model) {

		
		//get student from databse by id
		Student existingStudent=studentService.getStudentById(id);
		
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		
		//save uopdated student object
		studentService.updateStudent(existingStudent);
		
		return "redirect:/students";
		
		
		
	}
	
	
	
	//Handler method to handle delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id ) {
		
		studentService.deleteStudentById(id);
		return "redirect:/students";
		
		
	}
	
	
}
