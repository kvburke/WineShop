package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public class WebRepo{

	
	
	

	static ConcurrentHashMap<Integer, Account> accounts= new ConcurrentHashMap<Integer, Account>();
	
	@Autowired
	
	
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	
	private  JdbcTemplate jdbcTemplateObject = (JdbcTemplate)context.getBean("jdbcTemplate"); 
	

public void addAccount(int  account){
	Integer accountnumber=accounts.size();
	accounts.put(account, new Account(accountnumber ,accountnumber, "username"));
	
	//Register register= new Register();
	//@RequestParam("password") String password
	//register.save(new User("user6", "user6", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
	//register.save(new User("user7", "user7", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
	return;
}


public  List<AccountInventory> addAccount(String  name){
	String SQL = "SELECT account FROM inventory.users WHERE username='"+name+"'";
	List<AccountInventory> rows = new ArrayList<AccountInventory>();

	rows = jdbcTemplateObject.query(SQL, new AccountInventoryMapper());

	
	return rows;
}



public static void addUser(String username, String password){
	Random rand = new Random();
	SessionFactory sessionFactory;
	
	int account = rand.nextInt(1000);
	Users users = new Users();
	users.setUsername(username);
	users.setPassword(password);
	users.setEnabled(true);
	users.setAccount(account);
	
	sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	session.beginTransaction();
    session.save(users);
	;
    
	
	
	
	
	User_Roles role = new User_Roles();
	role.setUsername(username);
	role.setRole("ROLE_ADMIN");
	
	
	

    session.save(role);
	
    session.getTransaction().commit();
	
	
	
	return;	
}







public  ArrayList<Purchased> buyWine(int id, int account, String username, String name, String brand, double price, int quantity,  String url){	

	SessionFactory sessionFactory;
	
	
	
	
	
	
	Account account1 = accounts.get(account);
//Account account2 = new Account();
	
	
	

account1.setAccountnumber(account);
account1.setUsername(username);

Wine wine = new Wine();
Purchased purchase = new Purchased();
wine.setId(id);
purchase.setId(id);
wine.setUrl(url);
purchase.setUrl(url);
wine.setName(name);
purchase.setName(name);
wine.setBrand(brand);
purchase.setBrand(brand);
wine.setPrice(price);
purchase.setPrice(price);
wine.setQuantity(-(quantity));
purchase.setQuantity(quantity);


ShoppingCart shoppingcartforaccount1 = new ShoppingCart();
account1.setShoppingCart(accounts.get(account).getShoppingCart());
if (account1.getShoppingCart()==null){
account1.setShoppingCart(shoppingcartforaccount1);
accounts.put(account, account1);
}
account1.getShoppingCart().addWine(wine);
double total1=account1.getShoppingCart().total();

sessionFactory = new Configuration().configure().buildSessionFactory();
Session session = sessionFactory.getCurrentSession();
session.beginTransaction();
//session.save(wine);
//might need to uncomment session.save(purchase);
session.getTransaction().commit();



//account2.setAccountnumber(101);
//account2.setUsername("ed");
//Wine wine3 = new Wine();
//wine3.setName("Merlot");
//wine3.setPrice(20.20);
//wine3.setQuantity(1);
//Wine wine4= new Wine();
//wine4.setName("Chardonney");
//wine4.setPrice(10.21);
//wine4.setQuantity(2);
//ShoppingCart shoppingcartforaccount2 = new ShoppingCart();
//account2.setShoppingCart(shoppingcartforaccount2);
//account2.getShoppingCart().addWine(wine3);
//account2.getShoppingCart().addWine(wine4);
//double total2=account2.getShoppingCart().total();


System.out.print("Kevin Cart total " +total1 + "\n");
System.out.print("Kevin Items: \n");
accounts.put(account, account1);
account1=accounts.get(account);
System.out.print("Account 1 memory location"+account1);
return account1.getShoppingCart().getWineNamesandPrices();
//System.out.print("Ed Cart total " +total2 + "\n");
//System.out.print("Ed Items: \n");
//account2.getShoppingCart().getWineNames();
}


public  ArrayList<Purchased> buyWineInventory(int id, int account, String username, String name, String brand, double price, int quantity,  String url){	

	SessionFactory sessionFactory;
	
	
	
	
	
	
	Account account1 = accounts.get(account);
//Account account2 = new Account();
	
	
	

account1.setAccountnumber(account);
account1.setUsername(username);

Wine wine = new Wine();

wine.setId(id);

wine.setUrl(url);

wine.setName(name);

wine.setBrand(brand);

wine.setPrice(price);

wine.setQuantity(quantity);



ShoppingCart shoppingcartforaccount1 = new ShoppingCart();
account1.setShoppingCart(accounts.get(account).getShoppingCart());
if (account1.getShoppingCart()==null){
account1.setShoppingCart(shoppingcartforaccount1);
accounts.put(account, account1);
}
//account1.getShoppingCart().addWine(wine);
double total1=account1.getShoppingCart().total();

sessionFactory = new Configuration().configure().buildSessionFactory();
Session session = sessionFactory.getCurrentSession();
session.beginTransaction();
session.save(wine);
;
session.getTransaction().commit();



//account2.setAccountnumber(101);
//account2.setUsername("ed");
//Wine wine3 = new Wine();
//wine3.setName("Merlot");
//wine3.setPrice(20.20);
//wine3.setQuantity(1);
//Wine wine4= new Wine();
//wine4.setName("Chardonney");
//wine4.setPrice(10.21);
//wine4.setQuantity(2);
//ShoppingCart shoppingcartforaccount2 = new ShoppingCart();
//account2.setShoppingCart(shoppingcartforaccount2);
//account2.getShoppingCart().addWine(wine3);
//account2.getShoppingCart().addWine(wine4);
//double total2=account2.getShoppingCart().total();


System.out.print("Kevin Cart total " +total1 + "\n");
System.out.print("Kevin Items: \n");
accounts.put(account, account1);
account1=accounts.get(account);
System.out.print("Account 1 memory location"+account1);
return account1.getShoppingCart().getWineNamesandPrices();
//System.out.print("Ed Cart total " +total2 + "\n");
//System.out.print("Ed Items: \n");
//account2.getShoppingCart().getWineNames();
}




public  ArrayList<Purchased> removeWine(int idx, int id, int account, String name, double price, int quantity,  String url, String brand)
{
	
	Wine wine = new Wine();
	
	Account account1 = accounts.get(account);
	System.out.print("Account 1 memory location"+account1+"account propety username"+account1.getUsername());
	
	account1.getShoppingCart().removeWine(id);
	accounts.put(account, account1);
	account1.setShoppingCart(account1.getShoppingCart());
	
	
	accounts.put(account, account1);
	SessionFactory sessionFactory;
	//Wine wine2 = null;
	//Wine wine = new Wine();
			//wine.setId(id);
			
			
			
	
			
			
			
			
	
	//Purchased purchase = new Purchased();
	//purchase.setId(id);
	//purchase.setName(name);
	//purchase.setPrice(price);
	//purchase.setQuantity(quantity);
			
			
			
			
	
	sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	//session.beginTransaction();
	
	
	
	//session.delete(wine);
	// session.delete(purchase);
    //session.flush();
    //session.getTransaction().commit();
    
    ///////might need to uncomment///
	//Transaction transaction = session.beginTransaction();
	//try {
	 // // your code
	 // String hql = "delete from Purchased where idx= :idx";
	 // Query query = session.createQuery(hql);
	  
	 // query.setInteger("idx", idx);
	 
	//  System.out.println(query.executeUpdate());
	  // your code end

	//  transaction.commit();
	//} catch (Throwable t) {
	//  transaction.rollback();
	//  throw t;
	//}
	
	
	
	
	
	
	
	
	Wine wine2 = new Wine();
	
	wine2.setId(id);

	wine2.setUrl(url);
	
	wine2.setName(name);
	
	wine2.setBrand(brand);
	
	wine2.setPrice(price);
	
	wine2.setQuantity(-quantity);
	
	
	
	ShoppingCart shoppingcartforaccount1 = new ShoppingCart();
	account1.setShoppingCart(accounts.get(account).getShoppingCart());
	if (account1.getShoppingCart()==null){
	account1.setShoppingCart(shoppingcartforaccount1);
	accounts.put(account, account1);
	}
	//account1.getShoppingCart().addWine(wine);
	//double total1=account1.getShoppingCart().total();
	
	sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session2 = sessionFactory.getCurrentSession();
	session2.beginTransaction();
    //session2.save(wine2); maybe uncomment
	;
    session2.getTransaction().commit();
	
	
	
	
	
	
	
    account1.getShoppingCart().removeWine(idx);
	
	
	

	
	
	accounts.put(account, account1);
	double total1=account1.getShoppingCart().total();
	System.out.println("Total is"+total1);
	
	return account1.getShoppingCart().getWineNamesandPrices();
	
}




public ArrayList<Purchased> removeWineInventory(int id, int account, String name, double price, int quantity)
{
	
	Wine wine = new Wine();
	
	Account account1 = accounts.get(account);
	System.out.print("Account 1 memory location"+account1+"account propety username"+account1.getUsername());
	
	account1.getShoppingCart().removeWine(id);

	account1.setShoppingCart(account1.getShoppingCart());
	
	SessionFactory sessionFactory;
	//Wine wine2 = null;
	//Wine wine = new Wine();
			//wine.setId(id);
			
			
			
	
			
			
			
			
	
	//Purchased purchase = new Purchased();
	//purchase.setId(id);
	//purchase.setName(name);
	//purchase.setPrice(price);
	//purchase.setQuantity(quantity);
			
			
			
			
	
	sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.getCurrentSession();
	//session.beginTransaction();
	
	
	
	//session.delete(wine);
	// session.delete(purchase);
    //session.flush();
    //session.getTransaction().commit();
    
    
	Transaction transaction = session.beginTransaction();
	try {
	  // your code
	  String hql = "delete from Wine where id= :id";
	  Query query = session.createQuery(hql);
	  
	  query.setInteger("id", id);
	 
	  System.out.println(query.executeUpdate());
	  // your code end

	  transaction.commit();
	} catch (Throwable t) {
	  transaction.rollback();
	  throw t;
	}
	
	

	
	
	accounts.put(account, account1);
	double total1=account1.getShoppingCart().total();
	System.out.println("Total is"+total1);
	
	return account1.getShoppingCart().getWineNamesandPrices();
	
}




public   List<WineInventory> displayInventory(){
	String SQL = "SELECT  sum(quantity), brand, url, price FROM inventory.wine group by brand, url, price;";
	List<WineInventory> rows = new ArrayList<WineInventory>();

	rows = jdbcTemplateObject.query(SQL, new WineInventoryMapper());

return rows;
	
}




public  List<Wine> displayWines(int account){
Account generalaccount = new Account();
//Account generalaccount= accounts.get(account);
ShoppingCart shoppingcart = new ShoppingCart();
generalaccount.setShoppingCart(shoppingcart);
List<Wine> wines =generalaccount.getShoppingCart().getWineDatabase();
//for(int i=0;i<wines.size();i++){
//System.out.println(wines.get(i).getId()+" "+wines.get(i).getBrand()+" "+ wines.get(i).getName());


//}
return wines;
}



public  List<Purchased> displayPurchased(int account){
Account generalaccount= accounts.get(account);
//List<Purchased> wines =generalaccount.getShoppingCart().getPurchasedDatabase(); important function maybe
List<Purchased> wines =generalaccount.getShoppingCart().getWineNamesandPrices();
//for(int i=0;i<wines.size();i++){
//System.out.println(wines.get(i).getId()+" "+wines.get(i).getBrand()+" "+ wines.get(i).getName());


//}
return wines;
}




public List<Total> getTotal(int account){
	Total total = new Total();
	List<Total> totallist= new ArrayList<Total>();
	Account generalaccount= accounts.get(account);
	System.out.print("account object is"+generalaccount);
	
	total.setTotal(generalaccount.getShoppingCart().total());
	totallist.add(total);
	return totallist;
}



	public void buy(int account){
		
		Account generalaccount = accounts.get(account);
		generalaccount.getShoppingCart().buy();
	}







}