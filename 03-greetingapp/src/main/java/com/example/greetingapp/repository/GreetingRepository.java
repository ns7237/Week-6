package com.example.greetingapp.repository;

import com.example.greetingapp.model.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<GreetingEntity, Long> {
}
