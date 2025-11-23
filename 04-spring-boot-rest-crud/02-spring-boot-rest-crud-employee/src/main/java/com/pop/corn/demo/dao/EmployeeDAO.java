package com.pop.corn.demo.dao;

import com.pop.corn.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
