package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface WebServiceI {

	public abstract void addAccountService(int account);

	public abstract List<AccountInventory> addAccountService(String name);

	public abstract void addUserService(String username, String password);

	public abstract ArrayList<Purchased> buyWineService(int id, int account,
			String username, String name, String brand, double price,
			int quantity, String url);

	public abstract ArrayList<Purchased> buyWineInventoryService(int id,
			int account, String username, String name, String brand,
			double price, int quantity, String url);

	public abstract ArrayList<Purchased> removeWineService(int idx, int id,
			int account, String name, double price, int quantity, String url,
			String brand);

	public abstract ArrayList<Purchased> removeWineInventoryService(int id,
			int account, String name, double price, int quantity);

	public abstract List<WineInventory> displayInventoryService();

	public abstract List<Wine> displayWinesService(int account);

	public abstract List<Purchased> displayPurchasedService(int account);

	public abstract List<Total> getTotal(int account);

	public abstract void buy(int account);

}