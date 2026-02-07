package com.pop2c.demo.dao;

import com.pop2c.demo.entity.Instructor;
import com.pop2c.demo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);
}
