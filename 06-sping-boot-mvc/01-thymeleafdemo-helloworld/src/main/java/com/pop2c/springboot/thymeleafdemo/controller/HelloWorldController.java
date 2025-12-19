package com.pop2c.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    // need a controller method the show the initial form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
        // This will return the view `src/main/resources/templates/helloworld-form.html`
    }

    // need a controller method to process the HTML Form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

}
