
// this is the third page or third step of the project
// here we write all the incomplete methods require in model class
// DAO = Data Access Object(means it access all the data of database)

package com.registrationApp.model;

import java.sql.*;

public interface DAOService {
	public void connectDB();//moment we call this method it should establish connection with database
//	After making connection we did C R U D operation and login operation
	public boolean verifyLogin(String email, String pass);// this method will return true if email and password are correct otherwise return false
//	in this method we save the record
	public void createRegistration(String name, String course, String email, String mobile);
//	now we develop a method for deleting the record
	public void deleteRegistration(String email);// delete record based on email
//	next method is for update the record which is based on email
	public void updateRegistration(String email,String mobile);
//  this method can have the logic to display all the registration on html page
	public ResultSet readAllRegistration();
	
}
