package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.demo.TestApiApplication;
import com.example.demo.dao.ProductRepositery;
import com.example.demo.entity.Product;

@Component
public class ProductService {

    private final TestApiApplication testApiApplication;

  @Autowired
 private ProductRepositery pr;

    ProductService(TestApiApplication testApiApplication) {
        this.testApiApplication = testApiApplication;
    }	
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
   
    public List<Product>  GetbyCompanyAndPrice(String comname,double price){
    	
    	List<Product> ls=pr.findByCompanyAndPrice(comname, price);
    	return ls;
    }
   
    public List<Product> GetbyNameAndCompanyAndPrice(String name, String comname,double price){
    	
    	List<Product> ls = pr.findByNameAndCompanyAndPrice(name, comname, price);

    return ls;
    }
   
public List<Product> GetTop5(){
    	
    	List<Product> ls = pr.findTop5ByOrderByPriceDesc();

    return ls;
    }
    
    
public List<Product> GetButtom5(){
	
	List<Product> ls = pr.findTop5ByOrderByPriceAsc();

return ls;
}
    
    
public List<Product> GetbyPricegreater(double price){
    	
    	List<Product> ls = pr.findByPriceIsGreaterThanEqual(price);

    return ls;
    }

public List<Product> GetbyPricelessthan(double price){
	
	List<Product> ls = pr.findByPriceIsLessThanEqual(price);

return ls;
}

public List<Product> GetbyPriceequals(double price){
	
	List<Product> ls = pr.findByPriceEquals(price);

return ls;
}
   
public List<Product> GetbyPriceascending(){
	
	List<Product> ls = pr.findByOrderByPriceAsc();

return ls;
}


public List<Product> GetbyPricedesc(){
	
	List<Product> ls = pr.findByOrderByPriceDesc();

return ls;
}



public List<Product> GetbyPriceebetween(double minprice, double maxprice){
    return pr.findByPriceBetween(minprice, maxprice);
}



//   like pattern 1.contains

     public List<Product> GetbyNamecontains(String name){
    	 List<Product> ls=pr.findByNameContainsAllIgnoreCase(name);
    	 return ls;
     }

//     2.start with    
     
     public List<Product> GetbyNameStartWith(String name){
    	 List<Product> ls=pr.findByNameStartingWithIgnoreCase(name);
    	 return ls;
     }
     
//   3.end with    
     
   public List<Product> GetbyNameEndtWith(String name){
  	 List<Product> ls=pr.findByNameEndingWithIgnoreCase(name);
  	 return ls;
   }

// 4.like     
   
 public List<Product> GetbyNameLike(String name){
	 List<Product> ls=pr.findByNameIsLike(name);
	 return ls;
 }

//4. Not like with    
 
public List<Product> GetbyNameNotLike(String name){
	 List<Product> ls=pr.findByNameNotLike(name);
	 return ls;
}
//==============================================================================   
   public void dltbyid( int id){
		
	      pr.deleteById(id);
	   
	   }

   public void dltbyname(String name){
	    pr.deleteAllByName(name);
	}

	public void dltbycompany(String company){
	    pr.deleteAllByCompany(company);
	}

	public void dltbyprice(double price){
	    pr.deleteAllByPrice(price);
	}

   //==============================================================================
   
     public void addnewproduct(Product ref) {
    	 pr.save(ref);
     }
     
     // ====================Update=============================
     
     public void updateallproduct(int id,Product ref) {
    	   Optional<Product>op= pr.findById(id);
    	   Product ob=op.get();
    	   ob.setName(ref.getName());
    	   ob.setCompany(ref.getCompany());
    	   ob.setPrice(ref.getPrice());
    	   pr.save(ob);
    	   
    	 
     }
     
   public void updatebyname(String name,int id) {
	   Optional<Product>op= pr.findById(id);
	   Product ob=op.get();
	   ob.setName(name);
	   pr.save(ob);
	   
   }
}
