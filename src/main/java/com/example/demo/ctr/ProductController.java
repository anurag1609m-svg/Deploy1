package com.example.demo.ctr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	@RequestMapping(value = "home",method=RequestMethod.GET)
	public String home() {
		
		return" This is home.......";
	}
	

	@RequestMapping(value = "about")
	public String about() {
		
		return" This is about.......";
	}
	
	@RequestMapping("contact")
	public String contact() {
		
		return" This is contact.......";
	}
	
	
	@GetMapping(value = "product/all")
	public List<Product>fetchall() 
	{
		 List<Product> ls=null;
		 ls=ps.getall();
		return ls;
	}
	
	

	@GetMapping("product/id/{id}")
	public Product fetchabyid(@PathVariable int id) {
	    return ps.getbyid(id);
	}


	@GetMapping("product/name/{name}")
	public List<Product> fetchabyname(@PathVariable String name) {
	    return ps.getbyname(name);
	}
  
	@GetMapping("product/cname/{comname}")
	public List<Product> fetchabycname(@PathVariable String comname) {
	    return ps.getbycomname(comname);
	}
	
	@GetMapping("product/price/{price}")
	public List<Product> fetchabyprice(@PathVariable double price) {
	    return ps.getbyprice(price);
	}
	
	@GetMapping("product/name/company/{name}/{comname}")
	public List<Product> fetchabynameandcname(
	        @PathVariable String name,
	        @PathVariable String comname) {

	    return ps.GetbyNameAndCompany(name, comname);
	}
  
	
	
	@GetMapping("product/name/price/{name}/{price}")
	public List<Product> fetchabynameandid(
	        @PathVariable String name,
	        @PathVariable double price ) {

	    return ps.GetbyNameAndPrice(name, price);
	}
	
	
	@DeleteMapping("product/id/{id}")
	public String Removebyid(@PathVariable int id) {
	    
		ps.dltbyid(id);
		
		return" Product is deleted" ;
	}
}
