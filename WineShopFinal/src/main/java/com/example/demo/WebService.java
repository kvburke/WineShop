package com.example.demo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;







@Service
public class WebService {
	
	WebRepo DAO = new WebRepo();

	
	
	
	@Transactional
	public  void addAccountService(int  account){
		 DAO.addAccount(account);
	}
	
	@Transactional
	public List<AccountInventory> addAccountService(String  name){
		return DAO.addAccount(name);
	}
	
	
	@Transactional
	public  void addUserService(String username, String password){
		DAO.addUser(username, password);
	}
	
	
	
	
	
	@Transactional
	public  ArrayList<Purchased> buyWineService(int id, int account, String username, String name, String brand, double price, int quantity, String url){	
		return DAO.buyWine(id, account, username, name, brand, price, quantity, url);
	}
	
	@Transactional
	public  ArrayList<Purchased> buyWineInventoryService(int id, int account, String username, String name, String brand, double price, int quantity,  String url){	
		return DAO.buyWineInventory(id, account, username, name, brand, price, quantity, url);
	}
	
	
	
	@Transactional
	public ArrayList<Purchased> removeWineService(int idx, int id, int account, String name, double price, int quantity,  String url, String brand)
	{
		return DAO.removeWine(idx, id, account, name, price, quantity, url, brand);
	}
	
	
	
	@Transactional
	public  ArrayList<Purchased> removeWineInventoryService(int id, int account, String name, double price, int quantity)
	{
		return DAO.removeWineInventory(id, account, name, price, quantity);	
	}
	
	
	
	@Transactional
	public List<WineInventory> displayInventoryService(){
		return DAO.displayInventory();	
	}
	
	
	
	@Transactional
	public  List<Wine> displayWinesService(int account){
		return DAO.displayWines(account);
	}
	
	
	@Transactional
	public  List<Purchased> displayPurchasedService(int account){
		return DAO.displayPurchased(account);
	}
	
	
	
	@Transactional
	public  List<Total> getTotal(int account){
		return DAO.getTotal(account);
	}
	
	
	@Transactional
	public  void buy(int account){
		 DAO.buy(account);
	}
	
	
	
	
	
	
	
	
	
	
	
	

    
    
}