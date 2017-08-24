package com.example.demo;


public class Wine {
	
	
	public Wine(){
		
	}
	public Wine(int idx, int id, String url, String brand, String name, double price, int quantity, boolean checked){
		this.idx=idx;
		this.id=id;
		this.url= url;
		this.brand= brand;
		this.name= name;
		this.price=price;
		this.quantity=quantity;
		this.checked=checked;
	}
	
	
	
	int idx;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	int id;
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
	String url;
	String brand;
	String name;
	double price;
	int quantity;
	boolean checked= false;
	
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
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
