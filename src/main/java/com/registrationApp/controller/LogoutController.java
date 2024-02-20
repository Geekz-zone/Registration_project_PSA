// THis is the thirteen step or thirteen file of the project 
/** logout krne k bad jb hum browser pr back button click krte h wo dobara s hmko registration page pr le jata h
 *  is disability ko du krne k lie hm session context ka use krte h session variable use krte h usme login information 
 *  dalte h h or logout controller m session variable s sari information remove kr dte h jisse logout krne k bad hm dobara s 
 *  koi feature use na krpae .
 */
package com.registrationApp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LogoutController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);//this will destroy the session(false) this keyword destroyed it and true keyword will create the session
		session.invalidate();//and this invalidate will unbinds or removes the objects presents in the session variable
		// this will redirected to login page on clicking logout button
		request.setAttribute("errorMssg", "Logged Out...");// if condition is false then throw this error mssg on login page
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");// this will call the view layer or jsp file
		rd.forward(request, response);
		
	}

}
