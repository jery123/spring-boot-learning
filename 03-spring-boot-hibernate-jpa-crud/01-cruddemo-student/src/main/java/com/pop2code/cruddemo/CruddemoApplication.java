package com.pop2code.cruddemo;

import com.pop2code.cruddemo.dao.StudentDAO;
import com.pop2code.cruddemo.entity.Student;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			createStudent(studentDAO);
		};
	}

    public void createStudent(StudentDAO studentDAO){

        // create the student object
        System.out.println("Creating newstudent object ...");
        Student student = new Student("Henri", "Carl", "henri@pop2code.com");

        // save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(student);

        // display the id of the saved student
		System.out.println("Saved student. Generated id:" + student.getId());
    }
}
