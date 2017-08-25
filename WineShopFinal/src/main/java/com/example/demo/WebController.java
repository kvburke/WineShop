package com.example.demo;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.Account;
import com.example.demo.Purchased;
import com.example.demo.Total;
import com.example.demo.Wine;


@Controller
public class WebController {
	
WebServiceI Service = new WebService();	
	
	
	static ConcurrentHashMap<Integer, Account> accounts= new ConcurrentHashMap<Integer, Account>();
	
	@Autowired
	
	
ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	
	private  JdbcTemplate jdbcTemplateObject = (JdbcTemplate)context.getBean("jdbcTemplate"); 
	
	
	
	@RequestMapping(value="/addaccount", method=RequestMethod.GET)
	public void addAccount(@RequestParam("account")int  account){
	Service.addAccountService(account);
	}
	
	@RequestMapping(value="/getaccountid", method=RequestMethod.GET)
	public @ResponseBody List<AccountInventory> addAccount(@RequestParam("name")String  name){
		return Service.addAccountService(name);
	}
	
	
	@RequestMapping(value="/addUser", method=RequestMethod.GET)
	public void addUser(@RequestParam("username")String username, @RequestParam("password")String password){
		Service.addUserService(username, password);
	}
	
	
	
	
	

	@RequestMapping(value="/addWine", method=RequestMethod.GET)
	public  ArrayList<Purchased> buyWine(@RequestParam("id")int id, @RequestParam("account")int account,@RequestParam("username") String username, @RequestParam("name")String name,@RequestParam("brand") String brand, @RequestParam("price")double price, @RequestParam("quantity")int quantity, @RequestParam("url") String url){	
	
		return Service.buyWineService(id, account, username, name, brand, price, quantity, url);
	}
	
	@RequestMapping(value="/addWineInventory", method=RequestMethod.GET)
	public  ArrayList<Purchased> buyWineInventory(@RequestParam("id")int id, @RequestParam("account")int account,@RequestParam("username") String username, @RequestParam("name")String name,@RequestParam("brand") String brand, @RequestParam("price")double price, @RequestParam("quantity")int quantity, @RequestParam("url") String url){	
	
		return Service.buyWineInventoryService(id, account, username, name, brand, price, quantity, url);
	}
	
	
	
	@RequestMapping(value="/removeWine", method=RequestMethod.GET)
	public @ResponseBody ArrayList<Purchased> removeWine(@RequestParam("idx") int idx, @RequestParam("id")int id, @RequestParam("account")int account, @RequestParam("name")String name, @RequestParam("price")double price, @RequestParam("quantity")int quantity, @RequestParam("url") String url, @RequestParam("brand")String brand)
	{
		
		return Service.removeWineService(idx, id, account, name, price, quantity, url, brand);
		
	}
	
	
	
	@RequestMapping(value="/removeWineInventory", method=RequestMethod.GET)
	public @ResponseBody ArrayList<Purchased> removeWineInventory(@RequestParam("id")int id, @RequestParam("account")int account, @RequestParam("name")String name, @RequestParam("price")double price, @RequestParam("quantity")int quantity)
	{
		
		return Service.removeWineInventoryService(id, account, name, price, quantity);
	}
	
	
	
	@RequestMapping(value="/displayWines", method=RequestMethod.GET)
	public  @ResponseBody List<Wine> displayWines(@RequestParam("account")int account){
	return Service.displayWinesService(account);
	}
	
	
	@RequestMapping(value="/displayPurchased", method=RequestMethod.GET)
	public  @ResponseBody List<Purchased> displayPurchased(@RequestParam("account")int account){
	return Service.displayPurchasedService(account);
	}
	
	
	@RequestMapping(value="/displayInventory", method=RequestMethod.GET)
	public  @ResponseBody List<WineInventory> displayInventory(){
		return Service.displayInventoryService();
		
	}
	
	
	
	@RequestMapping(value="/total", method=RequestMethod.GET)
	public @ResponseBody List<Total> getTotal(@RequestParam("account")int account){
	return Service.getTotal(account);
	}
	
	
	@RequestMapping(value="/403", method=RequestMethod.GET)
		public  void buy(@RequestParam("account") int account){
		 Service.buy(account);
		 return;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
   
    @RequestMapping(value={"/","home"})
        public String home(){
            return "home";
        }
    
    @RequestMapping(value={"/createaccount"})
    public String createaccount(){
        return "createaccount";
    }
    
   
    
   
    
    
    @RequestMapping(value={"/shoppingcart"})
    public String shoppingCart(){
        return "shoppingCart";
    }
    
    
    @RequestMapping(value={"/shoppingcart2"})
    public String shoppingCart2(){
        return "shoppingCart2";
    }
    
    @RequestMapping(value={"/shoppingcart3"})
    public String shoppingCart3(){
        return "shoppingCart3";
    }
    
    
   
    @RequestMapping(value={"/welcome"})
    public String welcome(){
        return "welcome";
    }
  
    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }
   
    @RequestMapping(value={"/login"})
    public String login(){
        return "login";
    }
   
   
    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }
    
    @RequestMapping(value="/addaccount?account=110")
    public String addacount(){
        return "http://localhost:8080/addaccount?account=110";
    }
    @RequestMapping(value="/addWine?id=1&account=111&name=kevinx&price=30.1&quantity=10&username=kevin&brand=lol&url=lol")
    public String addWine(){
        return "http://localhost:8080/addWine?id=1&account=111&name=kevinx&price=30.1&quantity=10&username=kevin&brand=lol&url=lol";
    }
    
    
    
}