package student.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import student.dao.StudentDao;
import student.model.Student;

@Component
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	private final Logger LOGGER = LoggerFactory.getLogger(StudentService.class);
	private List<Student> student_list = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		LOGGER.info("Initializing student service......");
		this.student_list = studentDao.getListStudent();
	}
	
	public List<Student> getListStudent() {
		int size = this.student_list.size();
		LOGGER.info("Sorting " + size + " students by id.....");	
		student_list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if(s1.getId() >= s2.getId()) return 1;
				else return -1;
			}
		});
		return student_list;
	}
	
	public List<Student> reverseListStudent() {
		int size = this.student_list.size();
		LOGGER.info("Reversing " + size + " students by id.....");	
		student_list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if(s2.getId() >= s1.getId()) return 1;
				else return -1;
			}
		});
		return student_list;
	}
	
	public List<Student> sortedListAlphabeticalOrder() {
		int size = this.student_list.size();
		LOGGER.info("Sorting " + size + " students by alphabtic order.....");
		student_list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.getName().compareTo(s2.getName());
			}
		});
		return student_list;
	}
	
	public List<Student> reversedListAlphabeticalOrder() {
		int size = this.student_list.size();
		LOGGER.info("Reversing " + size + " students by alphabtic order.....");
		student_list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s2.getName().compareTo(s1.getName());
			}
		});
		return student_list;
	}

	public List<Student> getStudent_list() {
		return student_list;
	}

	public void setStudent_list(List<Student> student_list) {
		this.student_list = student_list;
	}

}
