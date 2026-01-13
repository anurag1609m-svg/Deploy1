package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String imgurl;
	private String name;
	private  String company;
	private double price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product( String url,String name, String company, double price) {
		super();
		//id hatai kyuki    product  add karenege toh id nhi denge kyuki id auto genreted h toh   jb add hoga toh constructor me call hoga or constructor me id bhi h mtlb total 4 chije 
		this.imgurl=url;
		this.name = name;
		this.company = company;
		this.price = price;
	}
	
	
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", company=" + company + ", price=" + price + "]";
	}
		
}
