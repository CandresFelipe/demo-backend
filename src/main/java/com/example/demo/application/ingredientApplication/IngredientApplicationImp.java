package com.example.demo.application.ingredientApplication;

import java.util.UUID;

import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.domain.ingredientDomain.IngredientRepository;
import com.example.demo.domain.ingredientDomain.IngredientService;
import com.example.demo.dto.ingredientDto.CreateOrUpdateIngredientDTO;
import com.example.demo.dto.ingredientDto.IngredientDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientApplicationImp implements IngredientApplication {
    
    private final IngredientRepository ingredientRepository;
    
    @Autowired
    public IngredientApplicationImp(final IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientDTO add(CreateOrUpdateIngredientDTO dto) {
        //input
        Ingredient ingredient = IngredientService.create(dto);
        this.ingredientRepository.add(ingredient);
        //output
        return IngredientService.createDTO(ingredient);
    }

    @Override
    public IngredientDTO get(UUID id) {
        Ingredient ingredient = this.ingredientRepository.findById(id).orElseThrow();
       return IngredientService.createDTO(ingredient);
    }

    @Override
    public void update(UUID id, CreateOrUpdateIngredientDTO dto) {
        Ingredient ingredient = this.ingredientRepository.findById(id).orElseThrow();
        ingredient.name = dto.name;
        ingredient.price = dto.price;
        this.ingredientRepository.update(ingredient);
    }

    @Override
    public void delete(UUID id) {
        Ingredient ingredient = this.ingredientRepository.findById(id).orElseThrow();
        this.ingredientRepository.delete(ingredient);
    }
}
