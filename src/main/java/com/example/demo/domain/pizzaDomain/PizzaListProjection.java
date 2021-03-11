package com.example.demo.domain.pizzaDomain;

import java.util.UUID;


public interface PizzaListProjection {
    
    public Image getImage();
    public String getName();
    public UUID getId();
    public double getPrice();

    public interface Image{
        public String getUrl();
    }
}
