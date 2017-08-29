package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public interface WebRepoI {

	public abstract void addAccount(int account);

	public abstract List<AccountInventory> addAccount(String name);

	public abstract ArrayList<Purchased> buyWine(int id, int account,
			String username, String name, String brand, double price,
			int quantity, String url);

	public abstract ArrayList<Purchased> buyWineInventory(int id, int account,
			String username, String name, String brand, double price,
			int quantity, String url);

	public abstract ArrayList<Purchased> removeWine(int idx, int id,
			int account, String name, double price, int quantity, String url,
			String brand);

	public abstract ArrayList<Purchased> removeWineInventory(int id,
			int account, String name, double price, int quantity);

	public abstract List<WineInventory> displayInventory();

	public abstract List<Wine> displayWines(int account);

	public abstract List<Purchased> displayPurchased(int account);

	public abstract List<Total> getTotal(int account);

	public abstract void buy(int account);

	public abstract void addUser(String username, String password);

}