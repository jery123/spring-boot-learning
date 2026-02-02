package com.pop2c.demo;

import com.pop2c.demo.dao.AppDAO;
import com.pop2c.demo.dao.AppDAOImpl;
import com.pop2c.demo.entity.Instructor;
import com.pop2c.demo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO theAppDAO, AppDAOImpl appDAOImpl) {

		return runner -> {
//			createInstructor(theAppDAO);

			findInstructor(theAppDAO);
		};
	}

	private void findInstructor(AppDAO theAppDAO) {
		int theId = 2;

		System.out.println("Finding instructor id:" + theId);

		Instructor tempInstructor = theAppDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetails only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO theAppDAO) {
		/*
		Instructor instructor = new Instructor("Chad", "Darby", "darby@pop2c.com");

		// create the instructor details
		InstructorDetail tempInstructorDetail = new
				InstructorDetail("https://www.youtube.com/@pop2c", "Coding");

		// associate the objects
		instructor.setInstructorDetail(tempInstructorDetail);*/

		Instructor instructor = new Instructor("Madhu", "Patel", "patel@pop2c.com");

		// create the instructor details
		InstructorDetail tempInstructorDetail = new
				InstructorDetail("https://www.youtube.com/@pop2c", "Playing guitar");

		// associate the objects
		instructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor

		System.out.println("Saving instructor: " + instructor);
		theAppDAO.save(instructor);
		System.out.println("Done!");
	}


}
