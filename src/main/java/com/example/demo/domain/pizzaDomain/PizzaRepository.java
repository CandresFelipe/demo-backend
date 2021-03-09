package com.example.demo.domain.pizzaDomain;

import java.util.Optional;
import java.util.UUID;

public interface PizzaRepository {
    public void add(Pizza pizza);
    public Optional<Pizza> findById(UUID id);  
    public void update(Pizza pizza);
    //public void delete(Pizza pizza);
  
}
