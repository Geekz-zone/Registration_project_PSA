
//this is the eighth step or eighth file of the project

package com.registrationApp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.registrationApp.model.DAOService_Implemnt;


@WebServlet("/allReg")
public class GetAllRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GetAllRegistrationController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(20);// session timeout with 10 sec time interval we give time in seconds
//			if session variable is not equal to null means if it has value then then follows if condition and create registraion
			if(request.getAttribute("email")!=null) {
				// this method call the model layer 
				DAOService_Implemnt service = new DAOService_Implemnt();
				service.connectDB();
				ResultSet result = service.readAllRegistration();// this result variable have all the registration data now pass this data to view layer using request dispatcher
//			now passing this data to view
				request.setAttribute("result", result);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/RegistrationPage/allRegistrations.jsp");
//				else if session variable is equal to null means session is destroyed it ha no values now in this condition 
//				it will redirected or take us to login page
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
