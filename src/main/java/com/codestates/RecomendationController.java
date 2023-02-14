package com.codestates;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecomendationController {
    @GetMapping("/")
    public String helloWorld() {
        return "To-do Application !";
    }
}
