package com.example.helloapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloPageController {

    @GetMapping("/web")
    public String helloWeb(Model model) {
        model.addAttribute("message", "Hello from BridgeLabz using Thymeleaf!");
        return "hello";  // must match hello.html (without .html extension)
    }
}
