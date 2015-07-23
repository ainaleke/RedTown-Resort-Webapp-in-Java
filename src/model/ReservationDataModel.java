package model;

import java.sql.*;

import web_red_town.ReservationFormServlet;

public class ReservationDataModel {

	private static String firstnameModel;
	private static String lastnameModel;
	
	private static String url="jdbc:mysql://localhost:3306";
	private static String dbName="red_town_resort";
	private static String driver="com.mysql.jdbc.Driver";
	private static String  usernameModel="root";
	private static String passwordModel="saviour1";
	
	private static Connection conn=null;
	private static PreparedStatement preparedstatement=null;
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		System.out.println("MySQL Connection Success");
		String sql2="INSERT INTO myreservations2 (firstname, lastname) VALUES (" +"'" + firstnameModel + "','" +lastnameModel +"')";
		String sql="INSERT INTO myreservations2 (firstname, lastname) VALUES (?,?)";
		/**
		if(conn!=null)
		{
			System.out.println("Yes, Connection was a Success");
		}
		
		else
		{
			System.out.println("Failed to make a connection");
		}	
		conn.close();
	 **/
	}
	
	public static void initializeJdbc(){
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url+"/"+dbName,usernameModel,passwordModel);
			System.out.println("Database Connected");
			String sql="INSERT INTO reservations (firstname, lastname, phonenumber, email, roomtype, checkin, checkout, comments) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			preparedstatement=conn.prepareStatement(sql); //initialize the prepared statement in the init method
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void storeRecords(String firstname, String lastname,String phonenumber,String email,String roomtype, java.util.Date checkin,java.util.Date checkout,String comments) throws SQLException
	{
		preparedstatement.setString(1, firstname);
		preparedstatement.setString(2, lastname);
		preparedstatement.setString(3, phonenumber);
		preparedstatement.setString(4, email);
		preparedstatement.setString(5,roomtype);
		preparedstatement.setDate(6, new java.sql.Date(checkin.getTime())); 
		preparedstatement.setDate(7, new java.sql.Date(checkout.getTime()));
		preparedstatement.setString(8, comments);
		//preparedstatement.executeUpdate(sql);
		preparedstatement.executeUpdate();
	}
	

}
