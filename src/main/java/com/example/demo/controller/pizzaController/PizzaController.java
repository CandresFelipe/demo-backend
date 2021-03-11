package com.example.demo.controller.pizzaController;

import com.example.demo.dto.commentDto.CommentDTO;
import com.example.demo.dto.commentDto.CreateCommentDTO;
import com.example.demo.dto.pizzaDto.CreateOrUpdatePizzaDTO;
import com.example.demo.dto.pizzaDto.PizzaDTO;

import java.util.List;
import java.util.UUID;

import com.example.demo.application.pizzaAplication.PizzaApplication;
import com.example.demo.domain.pizzaDomain.PizzaListProjection;
import com.example.demo.domain.pizzaDomain.PizzaProjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/v1/pizzas")

public class PizzaController {
    private final PizzaApplication pizzaApplication;
    
    @Autowired
    public PizzaController(final PizzaApplication pizzaApplication) {
        this.pizzaApplication = pizzaApplication;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> createPizza(@RequestBody final CreateOrUpdatePizzaDTO dto) {
        PizzaDTO pizzaDTO = this.pizzaApplication.add(dto);
        return ResponseEntity.status(201).body(pizzaDTO);
    }

    @GetMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> getPizza(@PathVariable UUID id){
        PizzaDTO pizzaDTO = this.pizzaApplication.get(id);
        return ResponseEntity.ok(pizzaDTO);
    }
    @PutMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> updatePizza(@PathVariable UUID id, @RequestBody final CreateOrUpdatePizzaDTO dto) {
        PizzaDTO pizzaDTO = this.pizzaApplication.get(id);
        this.pizzaApplication.update(pizzaDTO.id,dto);
        return ResponseEntity.ok(pizzaDTO);
    }
    @DeleteMapping(path = "/{id}")
    public void deletePizza(@PathVariable UUID id){
        this.pizzaApplication.delete(id);
    }


    @PostMapping(path="/{id}/comments",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> createComment(@PathVariable UUID id, @RequestBody final CreateCommentDTO dto) {
        CommentDTO commentDTO = this.pizzaApplication.addComment(id, dto);
        return ResponseEntity.status(201).body(commentDTO);
    }

    @PostMapping(path="/{id}/ingredient/{ingredientID}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> createIngredient(
    @PathVariable UUID id
    ,@PathVariable UUID ingredientID){
        PizzaDTO pizzaDTO = this.pizzaApplication.addIngredient(id,ingredientID);
        return ResponseEntity.status(201).body(pizzaDTO);
    }

    @PutMapping(
    path="/{id}/ingredient/{ingredientID}",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> removeIngredient(
    @PathVariable UUID id
    ,@PathVariable UUID ingredientID){
        PizzaDTO pizzaDTO = this.pizzaApplication.removeIngredient(id,ingredientID);
        return ResponseEntity.status(201).body(pizzaDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findPizzas(@RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        List<PizzaProjection> result = this.pizzaApplication.findAll(name, page, size);
        return ResponseEntity.ok(result);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findPizzaList(@RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        List<PizzaListProjection> result = this.pizzaApplication.findPizzaListAll(name, page, size);
        return ResponseEntity.ok(result);
    }


    
}