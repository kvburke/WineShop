package com.example.demo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ShoppingCart{
	
	
	public ShoppingCart(){
		
	}

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	
	List <Wine> cart= new ArrayList<Wine>();
	
	
	
	public void addWine(Wine wine){
		cart.add(wine);
	}
	
	public void removeWine(int id){
		for(Iterator<Wine> iterator = cart.iterator(); iterator.hasNext(); ) {
		    if(iterator.next().id == id)
		        iterator.remove();
		}
		System.out.println("Executing removeWine cartsize is"+ cart.size());
		
	}
	
	public double total(){
		double total=0;
		for(int i=0; i<cart.size(); i++){
			total+=((cart.get(i).getPrice())*(cart.get(i).getQuantity()));
			System.out.println("--sum--"+total);
		}
		double abstotal=java.lang.Math.abs(total);
		return abstotal;
		}
	public ArrayList<Purchased> getWineNamesandPrices(){
		ArrayList<Purchased> orders= new ArrayList<Purchased>();
		double price=0;
		for(int i=0; i<cart.size(); i++){
			String brand= cart.get(i).getBrand();
			int id = cart.get(i).getId();
			String name= cart.get(i).getName();
			price= cart.get(i).getPrice();
			int quantity= cart.get(i).getQuantity();
			String url = cart.get(i).getUrl();
			orders.add(new Purchased(brand, id, name, price, quantity, url));
			System.out.println(name+" "+price+" "+url+" |"+"\n");
		}
		
		return orders;
	}
	
	public double getTotalPrice(){
		
		ArrayList<Purchased> orders= new ArrayList<Purchased>();
		double price=0;
		for(int i=0; i<cart.size(); i++){
			String name= cart.get(i).getName();
			price+= cart.get(i).getPrice();
			System.out.println(name+" "+price+"\n");
		}
		
		double absprice=java.lang.Math.abs(price);
		return absprice;
	}
	
	
	public List<Wine> getWineDatabase(){
		
		//sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String name="kevin";
	  List<Wine> wines = session.createQuery("from Wine").list();
	  
	  
	  
	  
	    session.getTransaction().commit();
	    
	    wines.forEach(c -> c.setIdx(0));
		//String hql = "from Wine";
	   // Query query = session.createQuery(hql);
	   	
	    		
	    		
	   // List<Wine> diswines= new ArrayList<>(new HashSet<>(wines));
	    return wines;
	   
	    
		
	}
	
	
	public List<Purchased> getPurchasedDatabase(String name){
		
		//sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
	  
		Query query= session.createQuery("from Purchased where name = :name");
		query.setParameter("name", name);
		List<Purchased> purchases = query.list();
	    session.getTransaction().commit();
	    
	    //purchases.forEach(c -> c.setIdx(0));
		//String hql = "from Wine";
	   // Query query = session.createQuery(hql);
	    		
	    		
	    		
	   // List<Wine> diswines= new ArrayList<>(new HashSet<>(wines));
	    return purchases;
	   
	    
		
	}
	
	
	
	public void buy(){
		ArrayList<Purchased> orders= new ArrayList<Purchased>();
		ArrayList<Wine> wineorders= new ArrayList<Wine>();
		double price=0;
		for(int i=0; i<cart.size(); i++){
			String brand= cart.get(i).getBrand();
			int id = cart.get(i).getId();
			String name= cart.get(i).getName();
			price= cart.get(i).getPrice();
			int quantity= cart.get(i).getQuantity();
			String url = cart.get(i).getUrl();
			orders.add(new Purchased(brand, id, name, price, quantity, url));
			wineorders.add(new Wine(0,id, url, brand, name, price, quantity, true));
			System.out.println(name+" "+price+" "+url+"\n");
		}
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		for(int i=0; i<orders.size(); i++){
			Purchased order = orders.get(i);
			Wine wineorder = wineorders.get(i);
			session.save(order);
			session.save(wineorder);
			
		}
		session.getTransaction().commit();
		
		return;
	}
	
	
	
		
	}
	
	
	
	

