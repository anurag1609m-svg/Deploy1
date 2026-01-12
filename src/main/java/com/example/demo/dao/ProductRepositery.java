package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.example.demo.entity.Product;

import jakarta.transaction.Transactional;

public interface ProductRepositery extends JpaRepository<Product, Integer> {

	  List<Product> findByName(String name);

	  List<Product> findByCompany(String company);

	  List<Product> findByPrice(double price);

	  List<Product> findByNameAndCompany(String name, String company);

	  List<Product> findByNameAndPrice(String name, double price);

	  List<Product> findByCompanyAndPrice(String company, double price);

	  List<Product> findByNameAndCompanyAndPrice(String name, String company, double price);
	  
	  
	  
	  
	  //================   fetch top 5 by name ================================//
	   
       
                        
	
	  List<Product> findTop5ByOrderByPriceAsc();
	  List<Product> findTop5ByOrderByPriceDesc();
	  
	  
	  //=================Fetch by price =======================================
	  
	  
	  
	  List<Product> findByPriceIsGreaterThanEqual(double price);
	  List<Product> findByPriceIsLessThanEqual(double price);
	  List<Product>  findByPriceEquals(double price);
	  
	  List<Product> findByOrderByPriceAsc();
      List<Product> findByOrderByPriceDesc();
	  List<Product> findByPriceBetween(double minprice, double maxprice);

	  List<Product>  findByNameContainsAllIgnoreCase(String name);
	  List<Product> findByNameStartingWithIgnoreCase(String name);
	  List<Product> findByNameEndingWithIgnoreCase(String name);


	  List<Product> findByNameIsLike (String name);
	  List<Product> findByNameNotLike (String name);
	  
	  
	  List<Product> findByNameIsLike%_a (String name);
	  
//======================== Delete patterns =================================
	  
	  @Transactional  
	  void deleteAllByName(String name);
	  @Transactional
	  void deleteAllByCompany(String company);
	  @Transactional
	  void deleteAllByPrice(double price);

	 
	  

	}


