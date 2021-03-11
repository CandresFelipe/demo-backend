package com.example.demo.infraestructure.pizzaInfraestructure;

import java.util.UUID;
import java.util.List;

import com.example.demo.domain.pizzaDomain.PizzaProjection;
import com.example.demo.domain.pizzaDomain.Pizza;
import com.example.demo.domain.pizzaDomain.PizzaListProjection;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PizzaJPARepository extends JpaRepository<Pizza, UUID> {
    @Query("SELECT p FROM Pizza p WHERE id = :id")
   public PizzaProjection findByCriteria(@Param("id") UUID id);

   @Query("SELECT p FROM Pizza p WHERE (:name is NULL or name like %:name%)")
   public List<PizzaListProjection> findPizzaListByCriteria(@Param("name") String name, Pageable page);
     
}

//TODO arreglar join jpql