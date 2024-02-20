//this is the tenth step or tenth file of the project
// this controller can call call the model which have the logic for delete operation
package com.registrationApp.controller;

import java.io.IOException;

import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.registrationApp.model.DAOService_Implemnt;

@WebServlet("/deleteRegistration")
public class DeleteRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteRegController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("emailId");
		System.out.println(email);
//		call the model by creating the object of the model
		DAOService_Implemnt service = new DAOService_Implemnt();
		service.connectDB();
		service.deleteRegistration(email);
		
		ResultSet result = service.readAllRegistration();// this result variable have all the registration data now pass this data to view layer using request dispatcher
//		now passing this data to view
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/RegistrationPage/allRegistrations.jsp");
			rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
