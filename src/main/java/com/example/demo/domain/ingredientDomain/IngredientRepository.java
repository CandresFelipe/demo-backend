package com.example.demo.domain.ingredientDomain;

import java.util.Optional;
import java.util.UUID;


public interface IngredientRepository {
    public void add(Ingredient ingredient);
    public Optional<Ingredient> findById(UUID id);  
    public void update(Ingredient ingredient);
    public void delete(Ingredient ingredient);
}
