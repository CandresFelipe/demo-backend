package com.example.demo.domain.ingredientDomain;

import java.math.BigDecimal;
import java.util.UUID;

public interface IngredientProjection {
    public String getName();
    public UUID getId();
    public BigDecimal getPrice();
}