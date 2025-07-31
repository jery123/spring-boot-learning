package com.popcode.springcoredemo.rest;


import com.popcode.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a pricete field for dependency
    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach")    Coach theCoach) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
    }

    // define the
    @GetMapping("/dailyworkout")
    public String getDaiyWorkou(){
        return myCoach.getDailyWorkout();
    }

}
