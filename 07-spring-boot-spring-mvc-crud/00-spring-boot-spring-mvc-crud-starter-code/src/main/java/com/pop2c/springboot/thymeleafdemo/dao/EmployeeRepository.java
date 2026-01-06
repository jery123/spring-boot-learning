package com.pop2c.springboot.thymeleafdemo.dao;

import com.pop2c.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
    /**
     * Spring Data JPA will parse the method name
     * Look for a specific format and pattern
     * Creates appropriate query ... behind the scenes
     */

}
