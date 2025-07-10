package com.popcode.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties for: coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // expose new endpoint for "teaminfo"

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team Name: " + teamName;
    }

    // expose '/' that return 'Hello world'
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    //expose a new endpoint for workout
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "My daily 5k!";
    }

    //expose a new component for fortune
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day.";
    }
}
