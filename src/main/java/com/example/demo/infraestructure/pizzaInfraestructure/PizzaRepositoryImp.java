package com.example.demo.infraestructure.pizzaInfraestructure;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.domain.pizzaDomain.Pizza;
import com.example.demo.domain.pizzaDomain.PizzaProjection;
import com.example.demo.domain.pizzaDomain.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaRepositoryImp implements PizzaRepository {

    private final PizzaJPARepository pizzaJPARepository;

    @Autowired
    public PizzaRepositoryImp (final PizzaJPARepository pizzaJPARepository){
        this.pizzaJPARepository=pizzaJPARepository;
    }

    @Override
    public void add(Pizza pizza) {
        this.pizzaJPARepository.save(pizza);
    }

    @Override
    public Optional<Pizza> findById(UUID id) {
        return this.pizzaJPARepository.findById(id);
    }

    @Override
    public void update(Pizza pizza) {
       this.pizzaJPARepository.save(pizza);    
    }

    @Override
    public void delete(Pizza pizza) {
        this.pizzaJPARepository.delete(pizza);
        
    }

    @Override
    public List<PizzaProjection> findAll(String name, int page, int size) {
        return this.pizzaJPARepository.findByCriteria(name,
                PageRequest.of(page, size, Sort.by("name").descending()));
    }
   
}
