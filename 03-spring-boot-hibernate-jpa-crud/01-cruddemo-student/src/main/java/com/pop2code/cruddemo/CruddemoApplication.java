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
			//createStudent(studentDAO);
            //createMultipleStudent(studentDAO);
            readStudent(studentDAO);
		};
	}

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating new student object ...");
        Student student = new Student("David", "Kuate", "david@gmail.com");

        // save the student
        System.out.println("Saving the student ...");
        studentDAO.save(student);

        // display the id of the saved student
        int theId = student.getId();
        System.out.println("Saved student.  Generated id: " + theId);

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with the id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // display student
        System.out.println("Found the student: " + myStudent);
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
    
    // create multiple student
    public void createMultipleStudent(StudentDAO studentDAO){
        // creating 3 students
        System.out.println("Creating 3 newstudent object ...");
        Student std1 = new Student("Arnauld", "Guefack", "arnauld@gmail.com");
        Student std2 = new Student("Prisca", "Elegance", "prisca@gmail.com");
        Student std3 = new Student("Blanche", "Eclaire", "blanche@gmail.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(std1);
        studentDAO.save(std2);
        studentDAO.save(std3);
    }
}
