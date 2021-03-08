package com.example.demo.infraestructure.pizzaInfraestructure;

import java.util.UUID;

import com.example.demo.domain.pizzaDomain.Pizza;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaJPARepository extends JpaRepository<Pizza, UUID> {
    
}
