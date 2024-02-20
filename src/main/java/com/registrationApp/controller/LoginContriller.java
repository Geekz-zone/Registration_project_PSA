// this is the second page or second step of the Project

/** this is the controller of login.jsp file which read the data from front end(view)
 * and pass the data to model where we write all business logic or database code
 * after this we create a interface where we define all incomplete methods of the 
 * model class where we write logic
 */
/* Session TimeOut :- Many time we see in the software that we have logged in and after we logged in and leave it idle for 
 * sometime once we leave it idle for sometime and then when we interact auto logout should happen this auto loged out is 
 * called session timeout
 *
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

import com.registrationApp.model.DAOService_Implemnt;


@WebServlet("/verifyLogin")
public class LoginContriller extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginContriller() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// here controller read data from front end and store the data in email and pass variable
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
// Now we create model object and call its methods so that controller 
		// gives the front end data to model and take back the data from model 
		DAOService_Implemnt service = new DAOService_Implemnt();
		service.connectDB();
//Now we call verifyLogin method so that database activity can be achieve
		boolean status = service.verifyLogin(email, pass);
//		now we put if condition if status is true then take me to registration page and if it is false then throw given error message
		if(status) {
			HttpSession session = request.getSession(true);//it means creating a session for solving logout problem
			session.setAttribute("email", email);//when login is successful then we are setting up the value in the session variable and during logout out we have to remove this value form the session variable
			
/*  Session time out eg : we set session time out for 10 sec  and when we login and leave the application idle(not interact with app)
 * for 10 second and after 10 second when we try to interact with the application then this session variable become null
 * which means object address present in it will become null
 */
			session.setMaxInactiveInterval(20);// session timeout with 10 sec time interval we give time in seconds
//			here if we put correct login detail then it take me to this Create_RegistrationFile
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/RegistrationPage/Create_RegistrationFile.jsp");
			rd.forward(request, response);
		}else {// and for filling wrong id and password this displays below error mssg
			request.setAttribute("errorMssg", "Invalid username/password");// if condition is false then throw this error mssg on login page
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");// this will call the view layer or jsp file
			rd.forward(request, response);
		}
	
	}                                                                             
                                                                           
}                                                                                   
// After called by view page this controller layer call the model layer and get the status
