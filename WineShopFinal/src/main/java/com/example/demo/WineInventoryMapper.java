package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class WineInventoryMapper implements RowMapper<WineInventory> {
	   public WineInventory mapRow(ResultSet rs, int rowNum) throws SQLException {
	      WineInventory inventory = new WineInventory();
	      //inventory.setId(rs.getInt("id"));
	     // inventory.setName(rs.getString("name"));
	      inventory.setSum(rs.getInt("sum(quantity)"));
	      inventory.setBrand(rs.getString("brand"));
	      inventory.setUrl(rs.getString("url"));
	      inventory.setPrice(rs.getDouble("price"));
	      return inventory;
	   }
	}