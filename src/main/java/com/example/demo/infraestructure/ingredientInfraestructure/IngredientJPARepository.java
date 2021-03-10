package com.example.demo.infraestructure.ingredientInfraestructure;

import java.util.List;
import java.util.UUID;
import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.domain.ingredientDomain.IngredientProjection;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IngredientJPARepository extends JpaRepository<Ingredient, UUID> {
    @Query("select i.id as id, i.name as name, i.price as price from Ingredient i where (:name is NULL or name like %:name%)")
    List<IngredientProjection> findByCriteria(@Param("name") String name, Pageable page);

}
