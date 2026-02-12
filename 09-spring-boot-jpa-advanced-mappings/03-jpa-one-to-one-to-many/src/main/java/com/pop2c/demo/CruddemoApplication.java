package com.pop2c.demo;

import com.pop2c.demo.dao.AppDAO;
import com.pop2c.demo.dao.AppDAOImpl;
import com.pop2c.demo.entity.Course;
import com.pop2c.demo.entity.Instructor;
import com.pop2c.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    private final AppDAOImpl appDAOImpl;

    public CruddemoApplication(AppDAOImpl appDAOImpl) {
        this.appDAOImpl = appDAOImpl;
    }

    public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO theAppDAO, AppDAOImpl appDAOImpl) {

		return runner -> {
//			createInstructor(theAppDAO);

//		 	findInstructor(theAppDAO);
            
//            deleteInstructor(theAppDAO);

//			findInstructorDetail(theAppDAO);

//			deleteInstructorDetail(theAppDAO);

            createInstructorWithCourses(theAppDAO);
		};
	}

    private void createInstructorWithCourses(AppDAO theAppDAO) {

		Instructor instructor = new Instructor("Susan", "Public", "darby@pop2c.com");

		// create the instructor details
		InstructorDetail tempInstructorDetail = new
				InstructorDetail("https://www.youtube.com/@vg", "Video Games");

		// associate the objects
		instructor.setInstructorDetail(tempInstructorDetail);

        // create some courses
        Course course1 = new Course("Spring Boot in Action");
        Course course2 = new Course("Spring MVC in Action");

        // add the courses to the instructor
        instructor.add(course1);
        instructor.add(course2);

        // save the instructor
        theAppDAO.save(instructor);

        // save the intructor
        //
        // NOTE: this will ALSO save the course
        // because of CascadeType.PERSIST
        //
        System.out.println("Saving instructor: " + instructor);
        System.out.println("The courses: " + instructor.getCourses());

        System.out.println("Done!");

    }

    private void deleteInstructorDetail(AppDAO theAppDAO) {

		int theId = 3;
		System.out.println("Deleting the instructor detqil" + theId);

		theAppDAO.deleteInstructorDetailById(theId);

		System.out.println("Done !");
	}

	private void findInstructorDetail(AppDAO theAppDAO) {
		int theId = 2;
		System.out.println("Find the instructor detail by the id " + theId);

		InstructorDetail tempInstructorDetail = theAppDAO.findInstructorDetailById(theId);

		System.out.println("TempInstructorDetail" + tempInstructorDetail);
		System.out.println("Instructor" + tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO theAppDAO) {

        int theId = 1;

        System.out.println("Deleting instructor id:" + theId);

        theAppDAO.deleteInstructorById(theId);
        System.out.println("Done!");
    }

    private void findInstructor(AppDAO theAppDAO) {
		int theId = 2	;

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
