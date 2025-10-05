package com.pop2code.cruddemo.dao;

import com.pop2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLasName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
