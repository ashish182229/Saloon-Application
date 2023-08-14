package com.cts.salon.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.salon.Model.Appointment;

@Repository
public class AppointmentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
	    return jdbcTemplate; 
	}
	
	public void setData(Appointment app)
	{
		String sql = "INSERT INTO USER VALUES(?,?)";

		try {
			
			int count = jdbcTemplate.update(sql, new Object[] { app.getPrice(),app.getAppointment() });


		} catch (Exception e) {
			e.printStackTrace();

		}
	}


}
