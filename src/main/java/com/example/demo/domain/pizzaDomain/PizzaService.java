package com.example.demo.domain.pizzaDomain;

import java.util.UUID;

import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.dto.pizzaDto.CreateOrUpdatePizzaDTO;
import com.example.demo.dto.pizzaDto.PizzaDTO;
import com.example.demo.dto.pizzaDto.PizzaIngredientDTO;

public class PizzaService {
    public static Pizza create (CreateOrUpdatePizzaDTO dto){
        Pizza pizza = new Pizza();
        pizza.name = dto.name;
        pizza.id= UUID.randomUUID();
        return pizza;
    }
    public static PizzaDTO createDTO(Pizza pizza){
        PizzaDTO pizzaDTO = new PizzaDTO();
        pizzaDTO.id = pizza.id;
        pizzaDTO.name = pizza.name;
        pizzaDTO.price = pizza.price;
        for (Ingredient ingredient : pizza.ingredients) {
            PizzaIngredientDTO pizzaIngredientDto = new PizzaIngredientDTO();
            pizzaIngredientDto.name = ingredient.name;
            pizzaIngredientDto.id = ingredient.id;
        }
        return pizzaDTO;
    }
    
}
