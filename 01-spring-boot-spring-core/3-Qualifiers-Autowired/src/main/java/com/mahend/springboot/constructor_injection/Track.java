package com.mahend.springboot.constructor_injection;

import org.springframework.stereotype.Component;

@Component
public class Track implements Coach {
    @Override
    public String getDailyworkout() {
        return "Run Hard";
    }
}
