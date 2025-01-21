package com.mahend.springboot.constructor_injection;

import org.springframework.stereotype.Component;

@Component
public class Cricket implements Coach{

    @Override
    public String getDailyworkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
