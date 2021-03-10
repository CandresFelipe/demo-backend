package com.example.demo.domain.pizzaDomain;

import java.util.List;
import java.util.UUID;


public interface PizzaProjection {
    public String getName();

    public UUID getId();

    public double getPrice();

    public List<PizzaIngredientProjection> getIngredients();
    public List<PizzaCommentProjection> getComments();

    public interface PizzaIngredientProjection {
        public String getName();
        public UUID getId();
    }
    public interface PizzaCommentProjection{
        public UUID getId();
        public String getText();
    }
}