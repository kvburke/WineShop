package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       
        
       // registry.addViewController("/shoppingcart").setViewName("ShoppingCart.html");
       // registry.addViewController("/shoppingcart2").setViewName("ShoppingCart2.html");
        registry.addViewController("/createaccount").setViewName("CreateAccount.html");
        registry.addViewController("/test").setViewName("Login.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
    
    

    
    

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false);
    }
    
    
    
    
 



}
