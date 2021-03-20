package com.example.demo.domain.pizzaDomain;

import java.math.BigDecimal;
import java.util.UUID;


public interface PizzaListProjection {
    
    public Image getImage();
    public String getName();
    public UUID getId();
    public BigDecimal getPrice();

    public interface Image{
        public String getPublic_id();
    }
}
