package com.example.demo.dto.pizzaDto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PizzaDTO {
    public UUID id;
    public String name;
    public double price;
    public Set<PizzaIngredientDTO> ingredients = new HashSet<PizzaIngredientDTO>();
}
