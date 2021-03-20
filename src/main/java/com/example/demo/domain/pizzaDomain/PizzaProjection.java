package com.example.demo.domain.pizzaDomain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public interface PizzaProjection {


    public String getName();

    public UUID getId();

    public BigDecimal getPrice();
    
    public Image getImage();

    public interface Image{
        public String getPublic_id();
    }

    public List<PizzaIngredientProjection> getIngredients();
    public List<PizzaCommentProjection> getComments();

    public interface PizzaIngredientProjection {
        public String getName();
        public UUID getId();
    }
    public interface PizzaCommentProjection{
        public UUID getId();
        public String getText();
        public int getRating();
        public Date getDate();
    }
}