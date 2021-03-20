package com.example.demo.domain.ingredientDomain;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import org.hibernate.annotations.Type;

@Entity
public class Ingredient {
    @Id
    @Type(type = "uuid-char")
    public UUID id;
    @Column(nullable = false, unique = true)
    public String name;
    @Column(nullable = false)
    public BigDecimal price;
}

