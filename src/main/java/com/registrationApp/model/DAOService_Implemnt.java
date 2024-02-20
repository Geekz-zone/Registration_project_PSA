package com.registrationApp.model;


// this is the fourth step of project where i implement interface
import java.sql.*;
public class DAOService_Implemnt implements DAOService {
 // Making con and stmnt object as nonstatic so it can be used in whole program
	private Connection con;
	private Statement stmnt;
	
	@Override
	public void connectDB() { //create a database and make connection with it here
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Nov_Reg_Db_Project","root","9691977312@Ka");
			stmnt = con.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean verifyLogin(String email, String pass) {
		try {
			ResultSet result = stmnt.executeQuery("select * from Login where email='"+email+"' and password='"+pass+"' ");
			return result.next();//this statement return boolean value means return true if condition is true
		} catch (Exception e) {
			e.printStackTrace();// otherwise if condition is false
		}// condition is true is if login email and password is correct if any thing is wrong then condition is false
		
		return false;// this will return false
	}

	@Override
	public void createRegistration(String name, String course, String email, String num) {
		// now doing insert operation so that we can save the data into database
		try {
			stmnt.executeUpdate("insert into registrationdetail values('"+name+"','"+course+"','"+email+"','"+num+"')");

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRegistration(String email) {
		try {
			stmnt.executeUpdate("delete from registrationdetail where email = '"+email+"'");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateRegistration(String email, String mobile) {
		try {
			// this query update the registration
			stmnt.executeUpdate("update registrationdetail set mobile='"+mobile+"' where email='"+email+"' ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
// the data of this method is pass to controller and controller give it to the view
	public ResultSet readAllRegistration() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registrationdetail");
			return result;
//			here we read all the registration data from the table of the database and return that whole data 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
