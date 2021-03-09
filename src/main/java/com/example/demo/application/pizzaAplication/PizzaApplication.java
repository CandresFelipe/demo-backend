package com.example.demo.application.pizzaAplication;

import java.util.UUID;

import com.example.demo.dto.commentDto.CommentDTO;
import com.example.demo.dto.commentDto.CreateCommentDTO;
import com.example.demo.dto.pizzaDto.CreateOrUpdatePizzaDTO;
import com.example.demo.dto.pizzaDto.PizzaDTO;

public interface PizzaApplication {
    public PizzaDTO add(CreateOrUpdatePizzaDTO dto);
    public PizzaDTO get (UUID id); 
    public void update(UUID id, CreateOrUpdatePizzaDTO dtos);
    public void delete(UUID id);  
    public CommentDTO addComment (UUID id, CreateCommentDTO dto );
    public PizzaDTO addIngredient (UUID id, UUID ingredientId);
    // public void removeIngredient (UUID id, UUID ingredientId);
}
