package com.example.demo;


public class Purchased {
	
	
	public Purchased(){
		
	}
	
	public Purchased(String brand, int id, String name, double price, int quantity, String url){
		
		
		this.brand=brand;
		this.id=id;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
		this.url=url;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	int idx;
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	int id;
	String url;
	String brand;
	String name;
	double price;
	int quantity;
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}