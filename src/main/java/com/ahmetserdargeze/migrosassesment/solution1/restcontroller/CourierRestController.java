package com.ahmetserdargeze.migrosassesment.solution1.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourierRestController {
    @GetMapping("/test")
    String all() {
        return "serdargeze";
    }

}
