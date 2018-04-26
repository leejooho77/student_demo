package student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import student.model.Student;
import student.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/student/id")
	public List<Student> getListStudent() {
		return studentService.getListStudent();
	}
	
	@RequestMapping(value="/reverse/id")
	public List<Student> reverseListStudent() {
		return studentService.reverseListStudent();
	}
	
	@RequestMapping(value="/student/alp")
	public List<Student> sortedListAlphabeticalOrder() {
		return studentService.sortedListAlphabeticalOrder();
	}
	
	@RequestMapping(value="reverse/alp")
	public List<Student> reverseListAlphabeticalOrder() {
		return studentService.reversedListAlphabeticalOrder();
	}
}
