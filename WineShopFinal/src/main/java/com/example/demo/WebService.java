package com.example.demo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;







@Service
public class WebService implements WebServiceI {
	
	WebRepo DAO = new WebRepo();

	
	
	
	/* (non-Javadoc)
	 * @see com.example.demo.WebServiceI#addAccountService(int)
	 */
	@Override
	@Transactional
	public  void addAccountService(int  account){
		 DAO.addAccount(account);
	}
	
	/* (non-Javadoc)
	 * @see com.example.demo.WebServiceI#addAccountService(java.lang.String)
	 */
	@Override
	@Transactional
	public List<AccountInventory> addAccountService(String  name){
		return DAO.addAccount(name);
	}
	
	
	/* (non-Javadoc)
	 * @see com.example.demo.WebServiceI#addUserService(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public  void addUserService(String username, String password){
		DAO.addUser(username, password);
	}
	
	
	
	
	
	/* (non-Javadoc)
	 * @see com.example.demo.WebServiceI#buyWineService(int, int, java.lang.String, java.lang.String, java.lang.String, double, int, java.lang.String)
	 */
	@Override
	@Transactional
	public  ArrayList<Purchased> buyWineService(int id, int account, String username, String name, String brand, double price, int quantity, String url){	
		return DAO.buyWine(id, account, username, name, brand, price, quantity, url);
	}
	
	/* (non-Javadoc)
	 * @see com.example.demo.WebServiceI#buyWineInventoryService(int, int, java.lang.String, java.lang.String, java.lang.String, double, int, java.lang.String)
	 */
	@Override
	@Transactional
	public  ArrayList<Purchased> buyWineInventoryService(int id, int account, String username, String name, String brand, double price, int quantity,  String url){	
		return DAO.buyWineInventory(id, account, username, name, brand, price, quantity, url);
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.example.demo.WebServiceI#removeWineService(int, int, int, java.lang.String, double, int, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public ArrayList<Purchased> removeWineService(int idx, int id, int account, String name, double price, int quantity,  String url, String brand)
	{
		return DAO.removeWine(idx, id, account, name, price, quantity, url, brand);
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.example.demo.WebServiceI#removeWineInventoryService(int, int, java.lang.String, double, int)
	 */
	@Override
	@Transactional
	public  ArrayList<Purchased> removeWineInventoryService(int id, int account, String name, double price, int quantity)
	{
		return DAO.removeWineInventory(id, account, name, price, quantity);	
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.example.demo.WebServiceI#displayInventoryService()
	 */
	@Override
	@Transactional
	public List<WineInventory> displayInventoryService(){
		return DAO.displayInventory();	
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.example.demo.WebServiceI#displayWinesService(int)
	 */
	@Override
	@Transactional
	public  List<Wine> displayWinesService(int account){
		return DAO.displayWines(account);
	}
	
	
	/* (non-Javadoc)
	 * @see com.example.demo.WebServiceI#displayPurchasedService(int)
	 */
	@Override
	@Transactional
	public  List<Purchased> displayPurchasedService(int account){
		return DAO.displayPurchased(account);
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.example.demo.WebServiceI#getTotal(int)
	 */
	@Override
	@Transactional
	public  List<Total> getTotal(int account){
		return DAO.getTotal(account);
	}
	
	
	/* (non-Javadoc)
	 * @see com.example.demo.WebServiceI#buy(int)
	 */
	@Override
	@Transactional
	public  void buy(int account){
		 DAO.buy(account);
	}
	
	
	
	
	
	
	
	
	
	
	
	

    
    
}