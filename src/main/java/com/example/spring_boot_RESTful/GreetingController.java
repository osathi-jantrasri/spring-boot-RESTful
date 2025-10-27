package com.example.spring_boot_RESTful;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting getMethodName(@RequestParam(defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
}
