package com.example.EcomSpringBoot.repo;


import com.example.EcomSpringBoot.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<product, Integer> {

    @Query("Select p from product p where " +
    "LOWER(p.name) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
    "LOWER(p.description) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
    "LOWER(p.brand) LIKE LOWER(CONCAT('%',:keyword,'%'))")
    List<product> searchProductsByKeyword(String keyword);
}
