package com.example.demo.domain.pizzaDomain;

import java.util.List;
import java.util.UUID;


public interface PizzaProjection {
    public String getName();

    public UUID getId();

    public double getPrice();

    List<PizzaIngredientProjection> getIngredient();

    public interface PizzaIngredientProjection {
        
        public String getName();
        public UUID getId();
    }
    //TODO pizza comments
}