package com.example.demo.application.pizzaAplication;

import java.util.List;
import java.util.UUID;

import com.example.demo.domain.commentDomain.Comment;
import com.example.demo.domain.commentDomain.CommentService;
import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.domain.ingredientDomain.IngredientRepository;
import com.example.demo.domain.pizzaDomain.Pizza;
import com.example.demo.domain.pizzaDomain.PizzaListProjection;
import com.example.demo.domain.pizzaDomain.PizzaProjection;
import com.example.demo.domain.pizzaDomain.PizzaRepository;
import com.example.demo.domain.pizzaDomain.PizzaService;
import com.example.demo.dto.commentDto.CommentDTO;
import com.example.demo.dto.commentDto.CreateCommentDTO;
import com.example.demo.dto.pizzaDto.CreateOrUpdatePizzaDTO;
import com.example.demo.dto.pizzaDto.PizzaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaApplicationImp implements PizzaApplication {

    private final PizzaRepository pizzaRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public PizzaApplicationImp(final PizzaRepository pizzaRepository, final IngredientRepository ingredientRepository) {
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public PizzaDTO add(CreateOrUpdatePizzaDTO dto) {
        // input
        Pizza pizza = PizzaService.create(dto);
        for (UUID ingredientID : dto.ingredients) {
            Ingredient ingredient = this.ingredientRepository.findById(ingredientID).orElseThrow();
            pizza.ingredients.add(ingredient);
        }
        Double price = pizza.calculatePrice();
        pizza.setPrice(price);
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
        for (UUID ingredientID : dto.ingredients) {
            Ingredient ingredient = this.ingredientRepository.findById(ingredientID).orElseThrow();
            pizza.addIngredient(ingredient);
        }
        this.pizzaRepository.update(pizza);
    }

    @Override
    public void delete(UUID id) {
        Pizza pizza = this.pizzaRepository.findById(id).orElseThrow();
        this.pizzaRepository.delete(pizza);
    }

    @Override
    public CommentDTO addComment(UUID id, CreateCommentDTO dto) {
        Pizza pizza = this.pizzaRepository.findById(id).orElseThrow();
        Comment comment = CommentService.create(dto);
        pizza.comments.add(comment);
        this.pizzaRepository.update(pizza);
        return CommentService.createDTO(comment);
    }

    @Override
    public PizzaDTO addIngredient(UUID id, UUID ingredientId) {
        Pizza pizza = this.pizzaRepository.findById(id).orElseThrow();
        Ingredient ingredient = this.ingredientRepository.findById(ingredientId).orElseThrow();
        pizza.ingredients.add(ingredient);
        Double price = pizza.calculatePrice();
        pizza.setPrice(price);
        this.pizzaRepository.update(pizza);
        return PizzaService.createDTO(pizza);
    }

    @Override
    public PizzaDTO removeIngredient(UUID id, UUID ingredientId) {
        Pizza pizza = this.pizzaRepository.findById(id).orElseThrow();
        Ingredient ingredient = this.ingredientRepository.findById(ingredientId).orElseThrow();
        pizza.ingredients.remove(ingredient);
        Double price = pizza.calculatePrice();
        pizza.setPrice(price);
        this.pizzaRepository.update(pizza);
        return PizzaService.createDTO(pizza);
    }

    @Override
    public List<PizzaProjection> findAll(String name, int page, int size) {
        return this.pizzaRepository.findAll(name, page, size);
    }

    @Override
    public List<PizzaListProjection> findPizzaListAll(String name, int page, int size) {
        return this.pizzaRepository.findPizzaListAll(name, page, size);
    }
}
