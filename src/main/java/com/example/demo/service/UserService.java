package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UserRepositery;

import com.example.demo.entity.User;

@Component
public class UserService {
	@Autowired
     private UserRepositery us;
	
	  public List<User> getall(){
		   List<User> ls=null;
		  ls = (List<User>) us.findAll();
		   return ls;
	   }
	  
	   public List<User> getbyid(int id){
		   List<User> ls=null;
		   ls=(List<User>) us.findByUid(id);
		   return ls;
		   
	   }
	   
	   public List<User> getbyname(String name){
		   List<User> ls=null;
		   ls=(List<User>) us.findByUname(name);
		   return ls;
		   
	   }
	   
	   public List<User> getbyemail(String email){
		   List<User> ls=null;
		   ls=(List<User>) us.findByEmail(email);
		   return ls;
		   
	   }

	   public List<User> getbyphone(long phone){
		   List<User> ls=null;
		   ls=(List<User>) us.findByphone(phone);
		   return ls;
		   
	   }
	   
	   public List<User> getbynameandemail(String name,String email){
		   List<User> ls=null;
		   ls=(List<User>) us.findByUnameAndEmail(name, email);
		   return ls;
		   
	   }
	   
	   public List<User> getbynameandphone(String name,long phone){
		   List<User> ls=null;
		   ls=(List<User>) us.findByUnameAndPhone(name,phone );
		   return ls;
		   
	   }

}
