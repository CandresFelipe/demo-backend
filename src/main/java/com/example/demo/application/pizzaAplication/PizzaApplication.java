package com.example.demo.application.pizzaAplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.pizzaDomain.PizzaProjection;
import com.example.demo.dto.commentDto.CommentDTO;
import com.example.demo.dto.commentDto.CreateCommentDTO;
import com.example.demo.dto.pizzaDto.CreateOrUpdatePizzaDTO;
import com.example.demo.dto.pizzaDto.PizzaDTO;

public interface PizzaApplication {
    
    public PizzaDTO add(CreateOrUpdatePizzaDTO dto);

    public PizzaDTO get(UUID id);

    public void update(UUID id, CreateOrUpdatePizzaDTO dtos);

    public void delete(UUID id);

    public CommentDTO addComment(UUID id, CreateCommentDTO dto);

    public PizzaDTO addIngredient(UUID id, UUID ingredientId);

    public PizzaDTO removeIngredient(UUID id, UUID ingredientId);

    public List <PizzaProjection> findAll(String name, int page, int size);
}
