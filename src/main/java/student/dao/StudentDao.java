package student.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import student.model.Student;

@Component
public class StudentDao {
	
	private Random random = new Random();
	private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private final Logger LOGGER = LoggerFactory.getLogger(StudentDao.class);

	public List<Student> getListStudent() {
		ArrayList<Student> student_list = new ArrayList<>();
		int list_size = random.nextInt(70) + 30;
		LOGGER.info("Generating " + list_size + " students.....");
		for(int j = 0; j < list_size; j++) {
			int size = random.nextInt(7) + 3;
			String name = "";
			for(int i = 0; i < size; i++) {
				int index = random.nextInt(25);
				name += ALPHABET.charAt(index);
			}
			LOGGER.info("Student \"" + name + "\" is inserted in " + j);
			student_list.add(new Student(name.substring(0, 1).toUpperCase() + name.substring(1)));
		}
		return student_list;
	}

}
