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

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    private final AppDAOImpl appDAOImpl;

    public CruddemoApplication(AppDAOImpl appDAOImpl) {
        this.appDAOImpl = appDAOImpl;
    }

    public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    private void log(String str){
        System.out.println("===> DEBURG: " + str);
    }
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO theAppDAO, AppDAOImpl appDAOImpl) {

		return runner -> {

		};
	}

	private void deleteCourseById(AppDAO theAppDAO) {
		int theId = 21;

		// log
		log("Deleting course id: " + theId);

		theAppDAO.deleteCourseById(theId);

		log("Done!");
	}

	private void updateCourse(AppDAO theAppDAO) {
		int theId = 21;

		// find the course
		log("Find id: " + theId);
		Course tempCourse = theAppDAO.findCourseById(theId);

		// update the course
		log("Updating the course . . .");
		tempCourse.setTitle("Enjoy the simple things in life");

		theAppDAO.update(tempCourse);

		log("Done!");
	}

	private void updateInstructor(AppDAO theAppDAO) {

        int theId = 7;

        // find the instruction
        log("Find the instructor by id: " + theId);
        Instructor tempInstructor = theAppDAO.findInstructorById(theId);

        // update the instruction last-name
        tempInstructor.setLastName("Patel");
        theAppDAO.update(tempInstructor);

        log("Done!");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO theAppDAO) {
        int theId = 7;

        // find the instructor
        System.out.println("Finding instructor with courses by id: " + theId);
        Instructor tempInstructor = theAppDAO.findInstructorByJoinFetch(theId);

        System.out.println("TempInstructor: " + tempInstructor);
        System.out.println("The associated courses: " + tempInstructor.getCourses());

        System.out.println("Done !");

    }

    private void findCoursesForInstructor(AppDAO theAppDAO) {

		int theId = 1;

		// find the instructor
		Instructor temInstructor = theAppDAO.findInstructorById(theId);
		System.out.print("tempInstructor: " + temInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = theAppDAO.findConrsesByInstructorId(theId);

		// associate the courses
		temInstructor.setCourses(courses);
		System.out.println("Associated courses: " + temInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO theAppDAO) {
        int theId = 1;
        System.out.println("Finding instructor with courses by id: " + theId);

        Instructor tempInstructor = theAppDAO.findInstructorById(theId);

        System.out.println("TempInstructor: " + tempInstructor);
        System.out.println("The associated courses: " + tempInstructor.getCourses());

        System.out.println("Done !");
    }

    private void createInstructorWithCourses(AppDAO theAppDAO) {

		Instructor tempInstructor = new Instructor("Susan", "Public", "darby@pop2c.com");

		// create the instructor details
		InstructorDetail tempInstructorDetail = new
				InstructorDetail("https://www.youtube.com/@vg", "Video Games");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

        // create some courses
        Course course1 = new Course("Spring Boot in Action");
        Course course2 = new Course("Spring MVC in Action");

        // add the courses to the instructor
		tempInstructor.add(course1);
		tempInstructor.add(course2);


        // save the instructor
        //
        // NOTE: this will ALSO save the course
        // because of CascadeType.PERSIST
        //
        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses: " + tempInstructor.getCourses());

		theAppDAO.save(tempInstructor);

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

        int theId = 7;

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
