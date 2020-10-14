package com.camelpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camelpractice.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

}
