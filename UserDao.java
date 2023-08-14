package com.cts.salon.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.salon.Model.User;

@Repository
public class UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
	    return jdbcTemplate; 
	}

	
		
public int registerUser(User user) {
		
		String sql = "INSERT INTO USER VALUES(?,?,?,?)";

		try {
			
			int count = jdbcTemplate.update(sql, new Object[] { user.getFname(),user.getLname(),user.getEmail(), user.getPassword() });

			return count;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}


	public String loginUser(User user) {
		
		String sql = "SELECT EMAIL FROM USER WHERE EMAIL=? AND PASSWORD=?";
		
		try {

			String userId = jdbcTemplate.queryForObject(sql, new Object[] {
					user.getEmail(), user.getPassword() }, String.class);

			return userId;
			
		} catch (Exception e) {
			return null;
		}
	}
}
