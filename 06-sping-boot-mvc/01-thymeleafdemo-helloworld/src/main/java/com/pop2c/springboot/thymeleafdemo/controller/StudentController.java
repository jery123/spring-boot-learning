package com.pop2c.springboot.thymeleafdemo.controller;

import com.pop2c.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Clock;
import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model theModel) {

        // create a new student object
        Student theStudent = new Student();

        // add a student object to the model attribute
        theModel.addAttribute("student", theStudent);

        // add the list of countries to the model
        theModel.addAttribute("countries", countries);

        // add the list of languages to the model
        theModel.addAttribute("languages", languages);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent) {
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    return "student-confirmation";
    }
}
