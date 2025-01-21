package com.springboot.demo.rest;

import com.springboot.demo.dao.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    private Coach coach;

    // Constructor Injection
    @Autowired
    public DemoRestController(@Qualifier("cricketCoach") Coach coach) {
        this.coach = coach;
    }

    /*
    // field injection
    @Autowired
    private Coach coach;
    */

    /*
    // Setter injection
    @Autowired
    public void setCoach(Coach coach) {
        this.coach = coach;
    }

     */

    @GetMapping("/get-dailyworkout")
    public String dailyWorkoutCricket() {
        return coach.getDailyWorkout();
    }

}
