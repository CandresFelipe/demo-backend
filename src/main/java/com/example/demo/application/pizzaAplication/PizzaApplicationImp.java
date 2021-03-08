package com.example.demo.application.pizzaAplication;

import java.util.UUID;

import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.domain.ingredientDomain.IngredientRepository;
import com.example.demo.domain.pizzaDomain.Pizza;
import com.example.demo.domain.pizzaDomain.PizzaRepository;
import com.example.demo.domain.pizzaDomain.PizzaService;
import com.example.demo.dto.pizzaDto.CreateOrUpdatePizzaDTO;
import com.example.demo.dto.pizzaDto.PizzaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaApplicationImp implements PizzaApplication {

    private final PizzaRepository pizzaRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public PizzaApplicationImp(
        final PizzaRepository pizzaRepository,
        final IngredientRepository ingredientRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public PizzaDTO add(CreateOrUpdatePizzaDTO dto) {
        // input
        Pizza pizza = PizzaService.create(dto);
        for(UUID ingredientID : dto.ingredients){
            Ingredient ingredient = this.ingredientRepository.findById(ingredientID).orElseThrow();
            pizza.ingredients.add(ingredient);
        }
            this.pizzaRepository.add(pizza);
        return PizzaService.createDTO(pizza);
    }

    @Override
    public PizzaDTO get(UUID id) {
        Pizza pizza = this.pizzaRepository.findById(id).orElseThrow();
        return PizzaService.createDTO(pizza);
    }

    @Override
    public void update(UUID id, CreateOrUpdatePizzaDTO dto) {
        Pizza pizza = this.pizzaRepository.findById(id).orElseThrow();
        pizza.name = dto.name;
        for(UUID ingredientID : dto.ingredients){
            Ingredient ingredient = this.ingredientRepository.findById(ingredientID).orElseThrow();
            pizza.ingredients.add(ingredient);
        }
        this.pizzaRepository.update(pizza);
    }

    // @Override
    // public PizzaDTO get(UUID id) {
    //     Pizza pizza = this.pizzaRepository.findById(id).orElseThrow();
    //     PizzaDTO pizzaDTO = new PizzaDTO();
    //     pizzaDTO.id = pizza.id;
    //     pizzaDTO.name = pizza.name;
    //     pizzaDTO.price = pizza.price;
    //     return pizzaDTO;
    // }

    // @Override
    // public void update(UUID id, CreateOrUpdatePizzaDTO dtos) {
    //     // Todo ?? para añadir o eliminar ingredientes y comentarios, donde ???
    // }

    // @Override
    // public void delete(UUID id) {
    //     // todo
    // }

}
