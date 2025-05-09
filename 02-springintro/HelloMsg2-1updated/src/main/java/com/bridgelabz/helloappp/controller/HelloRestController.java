package com.bridgelabz.helloappp.controller;

import org.springframework.web.bind.annotation.*;

import com.bridgelabz.helloappp.dto.UserDTO;

@RestController
@RequestMapping("/hello")
public class HelloRestController {

    // ✅ UC 1: Basic Hello message using GET
    @GetMapping
    public String sayHello() {
        return "Hello from BridgeLabz";
    }

    // ✅ UC 2: Hello with name as Query Parameter using GET
    @GetMapping("/query")
    public String sayHelloQuery(@RequestParam(value = "name") String name) {
        return "Hello " + name + " from BridgeLabz";
    }

    // ✅ UC 3: Hello with name as Path Variable using GET
    @GetMapping("/param/{name}")
    public String sayHelloPath(@PathVariable("name") String name) {
        return "Hello " + name + " from BridgeLabz";
    }

    // ✅ UC 4: Hello using POST method with JSON body (UserDTO)
    @PostMapping("/post")
    public String sayHelloPost(@RequestBody UserDTO user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName() + " from BridgeLabz";
    }

    // ✅ UC 5: Hello using PUT method with Path Variable and Query Param
    @PutMapping("/put/{firstName}")
    public String sayHelloPut(@PathVariable("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        return "Hello " + firstName + " " + lastName + " from BridgeLabz";
    }

}
