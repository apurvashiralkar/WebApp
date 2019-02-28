package com.lti.maven;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.dao.CustomerDao;

/**
 * Servlet implementation class RegisterCustomerServlet
 */
@WebServlet("/customer.register")
public class RegisterCustomerServlet extends HttpServlet {

    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		
		CustomerClass customer=new CustomerClass();
		customer.setId(id);
		customer.setName(name);
		customer.setEmail(email);
		
		CustomerDao dao=new CustomerDao();
		dao.add(customer);
		
		response.sendRedirect("confirmation.html");
	}

}
