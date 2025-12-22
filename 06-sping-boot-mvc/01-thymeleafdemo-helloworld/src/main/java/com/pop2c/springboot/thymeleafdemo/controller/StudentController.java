package com.pop2c.springboot.thymeleafdemo.controller;

import com.pop2c.springboot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Clock;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model theModel) {

        // create a new student object
        Student theStudent = new Student();

        // add student object to the model attribute
        theModel.addAttribute("student", theStudent);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent) {
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    return "student-confirmation";
    }
}
