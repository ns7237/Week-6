package com.example.greetingapp.controller;

import com.example.greetingapp.model.Greeting;
import com.example.greetingapp.model.GreetingEntity;
import com.example.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping
    public Greeting getGreeting() {
        return new Greeting("Hello from GET");
    }

    @PostMapping
    public Greeting postGreeting() {
        return new Greeting("Hello from POST");
    }

    @PutMapping
    public Greeting putGreeting() {
        return new Greeting("Hello from PUT");
    }

    @DeleteMapping
    public Greeting deleteGreeting() {
        return new Greeting("Hello from DELETE");
    }

    @GetMapping("/message")
    public String getGreetingMessage() {
        return greetingService.getGreeting();
    }

    @GetMapping("/custom")
    public String getCustomGreeting(@RequestParam(required = false) String firstName,
                                    @RequestParam(required = false) String lastName) {
        return greetingService.getCustomGreeting(firstName, lastName);
    }

    @PostMapping("/save")
    public GreetingEntity saveGreeting(@RequestBody String message) {
        return greetingService.saveGreeting(message);
    }

    @GetMapping("/{id}")
    public GreetingEntity getGreetingById(@PathVariable Long id) {
        return greetingService.findGreetingById(id);
    }

    @GetMapping("/all")
    public List<GreetingEntity> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PutMapping("/update/{id}")
    public GreetingEntity updateGreeting(@PathVariable Long id, @RequestBody String message) {
        return greetingService.updateGreeting(id, message);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
    }
}
