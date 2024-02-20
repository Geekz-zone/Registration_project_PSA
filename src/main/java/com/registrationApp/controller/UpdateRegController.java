// this is the eleventh step or eleventh file of the project
// this controller is give all the update data of the view to model and give it back to viewlayer

package com.registrationApp.controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.registrationApp.model.DAOService_Implemnt;


@WebServlet("/updateRegistration")
public class UpdateRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateRegController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// now read the update value from view(all registration page)
		String email = request.getParameter("emailId");
		String mobile = request.getParameter("mobile");
//		now we set attribute for email and mobile
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		// we create a new jsp file which has update page
		// with the help of request dispatcher call the update page
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/RegistrationPage/Update_RegistrationFile2.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// read the data from the updateRegistration page and pass it to model layer
		String email = request.getParameter("email");
		String mobile = request.getParameter("num");
//		now for calling update method from the model so create model class object and call the method
		DAOService_Implemnt service = new DAOService_Implemnt();
		service.connectDB();
		service.updateRegistration(email, mobile);
//		now we have to save the update data to database and update it on all registration page
		ResultSet result = service.readAllRegistration();// this result variable have all the registration data now pass this data to view layer using request dispatcher
		request.setAttribute("result", result);
//		now after saving all the updated data to database now display it on all registartion page
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/RegistrationPage/allRegistrations.jsp");
		rd.forward(request, response);
	}

}
