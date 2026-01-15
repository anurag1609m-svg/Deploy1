package com.example.demo.ctr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
@CrossOrigin(origins = "*")
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
	
//========================================================================================
	
	@CrossOrigin(origins = "*")
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
  
	@GetMapping("product/company/{comname}")
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
	public List<Product> fetchabynameandprice(
	        @PathVariable String name,
	        @PathVariable double price ) {

	    return ps.GetbyNameAndPrice(name, price);
	}
	
	@GetMapping("product/company/price/{comname}/{price}")
	public List<Product> fetchabycomnameandprice(
	        @PathVariable String comname,
	        @PathVariable double price ) {

	    return ps.GetbyCompanyAndPrice(comname, price);
	}
	
	
	@GetMapping("product/name/company/price/{name}/{comname}/{price}")
	public List<Product> fetchabynameorcomnameandprice(
	        @PathVariable String name,
	        @PathVariable String comname,
	        @PathVariable double price ) {

	    return ps.GetbyNameAndCompanyAndPrice(name, comname, price);
	}
	

	@GetMapping("product/top5")
	public List<Product> fetchtop5() {
	    return ps.GetTop5();
	}
	
	@GetMapping("product/buttom5")
	public List<Product> fetchbuttom5() {
	    return ps.GetButtom5();
	}
	
	// fetch by price     
	
	@GetMapping("product/price/greterthan/{price}")
	public List<Product> fetchabypricegreater(@PathVariable double price) {
	    return ps.GetbyPricegreater(price);
	}
	
	@GetMapping("product/price/lessthan/{price}")
	public List<Product> fetchabypriceless(@PathVariable double price) {
	    return ps.GetbyPricelessthan(price);
	}
	
	@GetMapping("product/price/equalto/{price}")
	public List<Product> fetchabypriceequal(@PathVariable double price) {
	    return ps.GetbyPriceequals(price);
	}
	
	@GetMapping("product/price/ascending")
	public List<Product> fetchabypriceascending(  ) {
	    return ps.GetbyPriceascending();
	}
	
	@GetMapping("product/price/decending")
	public List<Product> fetchabypricedescennding() {
	    return ps.GetbyPricedesc();
	}
	
	@GetMapping("product/startprice/{minprice}/endprice/{maxprice}")
	public List<Product> fetchabypricebetween(@PathVariable double minprice,@PathVariable double maxprice) {
	    return ps.GetbyPriceebetween(minprice,maxprice);
	}
	
	 
	//   like patterns 1.contains     
	
	
	@GetMapping("product/contains/{name}")
	public List<Product> fetchbynamecontains(@PathVariable String name){
		
		List<Product> ls=ps.GetbyNamecontains(name);
		return ls;
	}
	
	
//  like patterns 2.start with     
	
	
	@GetMapping("product/startwith/{name}")
	public List<Product> fetchbynameStartWith(@PathVariable String name){
		
		List<Product> ls=ps.GetbyNameStartWith(name);
		return ls;
	}
	
//  like patterns 3.end with     
	
	
	@GetMapping("product/endwith/{name}")
	public List<Product> fetchbynameEndWith(@PathVariable String name){
		
		List<Product> ls=ps.GetbyNameEndtWith(name);
		return ls;
	}
	
//  like patterns 4.like 
	
	
	@GetMapping("product/like/{name}")
	public List<Product> fetchbynamelike(@PathVariable String name){
		
		List<Product> ls=ps.GetbyNameLike(name);
		return ls;
	}	
	
//  like patterns 4.like 
	
	
	@GetMapping("product/notlike/{name}")
	public List<Product> fetchbynamenotlike(@PathVariable String name){
		
		List<Product> ls=ps.GetbyNameNotLike(name);
		return ls;
	}		
//===============================================================================
	
	//========Delete Mapping=============
	
	
	@DeleteMapping("product/id/{id}")
	public String Removebyid(@PathVariable int id) {
	    
		ps.dltbyid(id);
		
		return" Product is deleted" ;
	}
	
	@DeleteMapping("product/name/{name}")
	public String Removebyid(@PathVariable String name) {
	    
		ps.dltbyname(name);
		
		return" Product is deleted by name" ;
	}
	
	@DeleteMapping("product/company/{company}")
	public String Removebycompany(@PathVariable String company) {
	    
		ps.dltbycompany(company);
		
		return" Product is deleted by company" ;
	}
	
	
	@DeleteMapping("product/price/{price}")
	public String Removebyprice(@PathVariable double price) {
	    
		ps.dltbyprice(price);
		
		return" Product is deleted by price" ;
	}
	
	
	
//========================================================================================
	
	//=========Insert Mapping=============
	
	@PostMapping(value="add/product")
	public String Addproduct(@RequestBody Product ref) {
	ps.addnewproduct(ref);
	return"Product added"; 	
	}
	
//==========================================================================================
	
	  @PutMapping(value="product/{id}")
	  public String productupdate(@PathVariable ("id") int id,
			                      @RequestBody Product ref) {
		  
		  ps.updateallproduct(id,ref);
		  return" record updated";
	  }
	  
	  
//	  @PutMapping(value="product/{name}")
//	  public String productupdate(@PathVariable ("name") String name,
//			                      @RequestBody Product ref) {
//		  
//	  ps.updatebyname(name,ref);
//		  return" record updated";
//	}
	
	  
	 
	  
	  
}
