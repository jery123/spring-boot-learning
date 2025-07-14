package com.popcode.springcoredemo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a pricete field for dependency
    private Coach myCoach;

    // define a constructor for dependency
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }

    // define the
    @GetMapping("/dailyworkout")
    public String getDaiyWorkou(){
        return myCoach.getDailyWorkout();
    }

}
