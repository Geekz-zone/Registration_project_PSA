// this is the sixth step or sixth file of the project


package com.registrationApp.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.registrationApp.model.DAOService_Implemnt;

@WebServlet("/SaveRegController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistrationController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/RegistrationPage/Create_RegistrationFile.jsp");
		rd.forward(request, response);// this will call the create registration page when click on new registration link
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Set the whole code inside try catch block because session time out code will give null pointer exception
		try {
//			now we read or get the data from registration page
			String name = request.getParameter("name");
			String course = request.getParameter("course");
			String email = request.getParameter("email");
			String num = request.getParameter("num");
			
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(20);// session timeout with 10 sec time interval we give time in seconds
//			if session variable is not equal to null means if it has value then then follows if condition and create registraion
			if(session.getAttribute("email")!=null) {
//				now this data we pass to model layer and model layer should save this data
				DAOService_Implemnt service = new DAOService_Implemnt();// create  model layer object
				service.connectDB();// for to connect with db
				service.createRegistration(name, course, email, num);
//				now return a message after saving a record rather than a blank page
				request.setAttribute("msg","Your Registration Is Complete");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/RegistrationPage/Create_RegistrationFile.jsp");// call registration page
				rd.forward(request, response);
//				else if session variable is equal to null means session is destroyed it ha no values now in this condition 
//				it will redirected or take us to login page
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMssg","Session time out. Login Again!!!");// this msg display on the login page
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");// this will redirected to login page 
			rd.forward(request, response);
		}

	}
	
	

}
