package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.Properties;

import com.lti.maven.CustomerClass;

//Data Access Object(DAO)
public class CustomerDao {
	
	public void add(CustomerClass customer)
	{
		
		Connection conn=null;
		PreparedStatement stmt=null;

	
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Newuser123");
			
			Properties dbprops=new Properties();
			dbprops.load(this.getClass().getClassLoader().getResourceAsStream("dev-db.properties"));
			
			Class.forName(dbprops.getProperty("driverClassName"));
			conn = DriverManager.getConnection(dbprops.getProperty("url"), dbprops.getProperty("username"), dbprops.getProperty("password"));
			
			String sql= ("insert into customer values (?,?,?)");
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, customer.getId());
			stmt.setString(2, customer.getName());
			stmt.setString(3, customer.getEmail());
			stmt.executeUpdate();
		} catch (Exception e) {//bad should catch individual exceptions
		
			e.printStackTrace();//very bad ,should throw user defined exception instead
		}finally {
			try {stmt.close();}catch(Exception e) { }
			try {conn.close();}catch(Exception e) { }
			
		}
		
	}
	}

	
	
	


