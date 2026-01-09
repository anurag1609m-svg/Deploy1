package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Product;

public interface ProductRepositery extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);

    List<Product> findByCompany(String company);

    List<Product> findByPrice(double price);

    List<Product> findByNameAndCompany(String name, String company);
    
    List<Product> findByNameAndPrice(String name,double price);
}

