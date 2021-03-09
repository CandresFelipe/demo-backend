package com.example.demo.domain.pizzaDomain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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

    private Double price;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void setPrice(Double value) {
        this.price = value;
    }

    // agregar la columna al getter y poner el nombre
    @Column(nullable = false, name = "price")
    public Double getPrice() {
        return price;
    }

    public Double calculatePrice() {
        Double total = 0.0;
        for (Ingredient ingredient : this.ingredients) {
            total += ingredient.price;
        }
        total = total * 1.2;
        return total;
    }

    @ManyToMany()
    @JoinTable()
    public Set<Ingredient> ingredients = new HashSet<Ingredient>();
    
    @OneToMany()
    @JoinTable()
    public Set<Comment> comments = new HashSet<Comment>();
}
