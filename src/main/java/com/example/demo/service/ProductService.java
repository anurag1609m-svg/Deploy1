package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.ProductRepositery;
import com.example.demo.entity.Product;

@Component
public class ProductService {

  @Autowired
 private ProductRepositery pr;	
   public List<Product> getall(){
	   List<Product> ls=null;
	  ls = pr.findAll();
	   return ls;
   }
  
   public Product getbyid( int id){
	  Product ob= null;
	  
	Optional<Product> op=  pr.findById(id);
    ob=op.get();
    return ob;
   }
   
   public List<Product> getbyname( String name){
		
		  
		List<Product> op=  pr.findByName(name);
	   
	    return op;
	   }
 
   public List<Product> getbycomname( String comname){
		
		  
		List<Product> op=  pr.findByCompany(comname);
	   
	    return op;
	   }
    
   public List<Product> getbyprice( double price){
		
		  
		List<Product> op=  pr.findByPrice(price);
	   
	    return op;
	   }
   
   public List<Product> GetbyNameAndCompany( String name, String comname){  
		List<Product> op=  pr.findByNameAndCompany(name, comname);
	     return op;
	   }
   
   public List<Product> GetbyNameAndPrice( String name,double price ){  
		List<Product> op=  pr.findByNameAndPrice(name, price);
	     return op;
	   }
   
//==============================================================================   
   public void dltbyid( int id){
		
	      pr.deleteById(id);
	   
	   }

}
