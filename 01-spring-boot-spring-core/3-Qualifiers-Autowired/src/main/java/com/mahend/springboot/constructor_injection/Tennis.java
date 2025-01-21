package com.mahend.springboot.constructor_injection;

import org.springframework.stereotype.Component;

@Component
public class Tennis implements Coach {

    @Override
    public String getDailyworkout() {
        return "Practice your back hand volley";
    }
}
