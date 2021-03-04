package com.example.demo.domain.ingredientDomain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingredient {
    @Id
    public UUID id;
    
    @Column(nullable = false)
    public String name;
    @Column(nullable = false)
    public double price;
}

