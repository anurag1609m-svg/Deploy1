package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Product;
import com.example.demo.entity.User;

public interface UserRepositery extends JpaRepository<User, Integer> {

	public List<User> findByUid(int uid);
	public List<User> findByUname(String uname);
	public List<User> findByEmail(String email);
	public List<User> findByphone(long phone);
	
	public List<User>   findByUnameAndEmail (String uname,String email);
	
	public List<User>   findByUnameAndPhone (String uname,long phone);
   
}

