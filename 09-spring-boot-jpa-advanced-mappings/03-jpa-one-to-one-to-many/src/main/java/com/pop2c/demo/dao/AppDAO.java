package com.pop2c.demo.dao;

import com.pop2c.demo.entity.Course;
import com.pop2c.demo.entity.Instructor;
import com.pop2c.demo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findConrsesByInstructorId(int theId);

    Instructor findInstructorByJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);

    Course findCourseById(int theId);

}
