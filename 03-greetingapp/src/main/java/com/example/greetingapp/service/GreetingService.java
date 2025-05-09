package com.example.greetingapp.service;

import com.example.greetingapp.model.GreetingEntity;
import com.example.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository repository;

    public String getGreeting() {
        return "Hello World";
    }

    public String getCustomGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null)
            return "Hello " + firstName + " " + lastName;
        else if (firstName != null)
            return "Hello " + firstName;
        else if (lastName != null)
            return "Hello " + lastName;
        else
            return "Hello World";
    }

    public GreetingEntity saveGreeting(String message) {
        return repository.save(new GreetingEntity(message));
    }

    public GreetingEntity findGreetingById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<GreetingEntity> getAllGreetings() {
        return repository.findAll();
    }

    public GreetingEntity updateGreeting(Long id, String newMessage) {
        GreetingEntity entity = repository.findById(id).orElse(null);
        if (entity != null) {
            entity.setMessage(newMessage);
            return repository.save(entity);
        }
        return null;
    }

    public void deleteGreeting(Long id) {
        repository.deleteById(id);
    }
}
