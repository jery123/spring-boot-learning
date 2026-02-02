package com.pop2c.demo.dao;

import com.pop2c.demo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);
}
