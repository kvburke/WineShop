package com.example.demo;



public class Account {

	public Account(int accountnumber, int id, String username){
		this.accountnumber=accountnumber;
		this.id=id;
		this.username=username;
		this.ShoppingCart=null;
	}
	
	public Account(){
		
	}
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	String username;
	int accountnumber;
	ShoppingCart ShoppingCart;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	public ShoppingCart getShoppingCart() {
		return ShoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		ShoppingCart = shoppingCart;
	}
	
	
	
	
	
	
}
