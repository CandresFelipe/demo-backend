package com.example.demo.domain.pizzaDomain;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PizzaRepository {
    public void add(Pizza pizza);
    public Optional<Pizza> findById(UUID id);  
    public void update(Pizza pizza);
    public void delete(Pizza pizza);
    public PizzaProjection findAll(UUID id);
    public List <PizzaListProjection> findPizzaListAll(String name, int page, int size); 
}
