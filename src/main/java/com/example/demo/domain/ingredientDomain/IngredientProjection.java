package com.example.demo.domain.ingredientDomain;

import java.util.UUID;

public interface IngredientProjection {
    public String getName();
    public UUID getId();
    public double getPrice();
}