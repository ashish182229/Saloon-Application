package com.cts.salon.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.salon.Model.Facility;

import java.sql.*;

@Repository
public class FacilityDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
	    return jdbcTemplate; 
	}

	
	public List<Facility> allservices()
	{
		String sql = "SELECT * FROM hairstyle";
		List<Facility> query = jdbcTemplate.query(sql,new RowMapper<Facility>() {
			
			@Override
			public Facility mapRow(ResultSet rs, int arg1) throws SQLException {
				Facility h = new Facility();
				h.setId(rs.getInt("id"));
				h.setType(rs.getString("type"));
				h.setPrice(rs.getInt("price"));
				h.setImg(rs.getString("img"));
				return h;
			}
		});
		
		return query;
	}
	
	
	public List<Facility> allservicesCheckout()
	{
		String sql = "SELECT id,type,price FROM hairstyle";
		List<Facility> query = jdbcTemplate.query(sql,new RowMapper<Facility>() {
			
			@Override
			public Facility mapRow(ResultSet rs, int arg1) throws SQLException {
				Facility h = new Facility();
				h.setId(rs.getInt("id"));
				h.setType(rs.getString("type"));
				h.setPrice(rs.getInt("price"));
				return h;
			}
		});
		
		return query;
	}
	
	public List<Facility> allservicesColor()
	{
		String sql = "SELECT * FROM haircolor";
		List<Facility> query = jdbcTemplate.query(sql,new RowMapper<Facility>() {
			
			@Override
			public Facility mapRow(ResultSet rs, int arg1) throws SQLException {
				Facility h = new Facility();
				h.setId(rs.getInt("id"));
				h.setType(rs.getString("type"));
				h.setPrice(rs.getInt("price"));
				h.setImg(rs.getString("img"));
				return h;
			}
		});
		
		return query;
	}
	
	public List<Facility> allservicesColorCheckout()
	{
		String sql = "SELECT id,type,price FROM haircolor";
		List<Facility> query = jdbcTemplate.query(sql,new RowMapper<Facility>() {
			
			@Override
			public Facility mapRow(ResultSet rs, int arg1) throws SQLException {
				Facility h = new Facility();
				h.setId(rs.getInt("id"));
				h.setType(rs.getString("type"));
				h.setPrice(rs.getInt("price"));
				return h;
			}
		});
		
		return query;
	}
	
	public List<Facility> allservicesSpa()
	{
		String sql = "SELECT * FROM spa";
		List<Facility> query = jdbcTemplate.query(sql,new RowMapper<Facility>() {
			
			@Override
			public Facility mapRow(ResultSet rs, int arg1) throws SQLException {
				Facility h = new Facility();
				h.setId(rs.getInt("id"));
				h.setType(rs.getString("type"));
				h.setPrice(rs.getInt("price"));
				h.setImg(rs.getString("img"));
				h.setDes(rs.getString("des"));
				return h;
			}
		});
		
		return query;
	}
}
