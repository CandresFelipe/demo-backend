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
    @Column(nullable = false)
    public double price;
    @ManyToMany()
    @JoinTable()
    public Set<Ingredient> ingredients = new HashSet<Ingredient>();
    @OneToMany()
    @JoinTable()
    public Set<Comment> comments = new HashSet<Comment>();
}
