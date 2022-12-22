package com.jspiders.jbbc.dyanamicinsert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JdbcInsert 
{
	  private static Connection connection;
	     private static int result;
	     private static FileReader fileReader;
	     private static Properties properties;
	     private static String filepath;
		private static PreparedStatement PreparedStatement;
		private static Scanner s=new Scanner(System.in);
	     
	    public static void main(String[] args) {
			
	    	
	    	
	    	try {
	    		filepath="C:\\Users\\DELL\\eclipse-workspace\\Roshani\\WEJM4\\jdbc\\resources\\db-info.properties";
	    		
	    		fileReader=new FileReader(filepath);
	    		
	    		properties=new Properties();
	    		properties.load(fileReader);
	    		
	    		
	    		Class.forName(properties.getProperty("driverpath"));
	    		 connection =DriverManager.getConnection(properties.getProperty("dburl"),properties);
	    		
	    		PreparedStatement=connection.prepareStatement(properties.getProperty("query"));
	    		
	    		System.out.println("Enter the student id : ");
	    		int id=s.nextInt();
	    		PreparedStatement.setInt(1,id);
	    		
	    		System.out.println("Enter the student std_Name : ");
	    		String fname=s.next();
	    		PreparedStatement.setString(2,fname);
	   
	    		System.out.println("Enter the student std_number : ");
	    		long number=s.nextLong();
	    		PreparedStatement.setLong(3,number);
	    		
    		 System.out.println("Enter the student birthdate : ");	    	
    		    String birthdate=s.next();
	    		PreparedStatement.setString(4,birthdate);
	    		
	    		result=PreparedStatement.executeUpdate();
	    		
	    		System.out.println(result + " row(s) affected");
	   
	    		
		        
	    	}
	    	catch(SQLException e) {
	    	e.printStackTrace();
	    	}
	    	catch(ClassNotFoundException e) {
	    		e.printStackTrace();
	    	}
	    	catch(FileNotFoundException e) {
	    		e.printStackTrace();
	    	} catch (IOException e) {
				e.printStackTrace();
			}
	    	finally {
	    		
	    		
	    		try {
	    	
					if(connection != null)
					{
						connection.close();
					}
					if(PreparedStatement != null)
					{
						PreparedStatement.close();
					}
					
					
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
	    	}
}
