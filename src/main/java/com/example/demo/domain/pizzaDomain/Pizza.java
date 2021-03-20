package com.example.demo.domain.pizzaDomain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.example.demo.domain.Image.Image;
import com.example.demo.domain.commentDomain.Comment;
import com.example.demo.domain.ingredientDomain.Ingredient;

import org.hibernate.annotations.Type;

@Entity
public class Pizza {
    @Id
    @Type(type = "uuid-char")
    public UUID id;
    @Column(nullable = false)
    public String name;
    private BigDecimal price;
    
    @Embedded
    public Image image;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    // agregar la columna al getter y poner el nombre
    @Column(nullable = false, name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    
    public BigDecimal calculatePrice() {
        BigDecimal total = new BigDecimal(0.0);
        BigDecimal addPrice = new BigDecimal(1.2);
        for (Ingredient ingredient : this.ingredients) {
            total = total.add(ingredient.price);
        }
        total = total.multiply(addPrice);
        return total;
    }

    
    @ManyToMany()
    public Set<Ingredient> ingredients = new HashSet<Ingredient>();
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="pizza_id")
    public Set<Comment> comments = new HashSet<Comment>();
}
