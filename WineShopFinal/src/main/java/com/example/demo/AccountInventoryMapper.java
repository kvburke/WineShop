package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AccountInventoryMapper implements RowMapper<AccountInventory> {
	   public AccountInventory mapRow(ResultSet rs, int rowNum) throws SQLException {
	      AccountInventory inventory = new AccountInventory();
	      inventory.setAccount(rs.getInt("Account"));
	      
	      return inventory;
	   }
	}