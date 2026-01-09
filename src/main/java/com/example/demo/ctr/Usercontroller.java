package com.example.demo.ctr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class Usercontroller {
   
	@Autowired
	private UserService us;
	
	   @GetMapping(value = "user/getall" )
	   public List<User> fetchalluser() {
		   List<User> ls= null;
		   ls=us.getall();
		   
		   return ls;
	   }

	   @GetMapping(value = "user/id/{id}"  )
	   public List<User> fetchuserbyid(@PathVariable int id) {
		   List<User> ls= null;
		   ls=us.getbyid(id);
		   
		   return ls;
	   }
	   
	   @GetMapping(value = "user/name/{name}"  )
	   public List<User> fetchuserbyname(@PathVariable String name) {
		   List<User> ls= null;
		   ls=us.getbyname(name);
		   
		   return ls;
	   }
	   
	   @GetMapping(value = "user/email/{email}"  )
	   public List<User> fetchuserbyid(@PathVariable String email) {
		   List<User> ls= null;
		   ls=us.getbyemail(email);
		   
		   return ls;
	   }
	   
	   @GetMapping(value = "user/phone/{phone}"  )
	   public List<User> fetchuserbyid(@PathVariable long phone) {
		   List<User> ls= null;
		   ls=us.getbyphone(phone);
		   
		   return ls;
	   }

	        
}
