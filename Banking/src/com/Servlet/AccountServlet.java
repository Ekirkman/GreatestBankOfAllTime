package com.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Account;
import com.user.Address;
import com.user.Customer;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Customer customer = new Customer();
		customer.setEmailAddress(request.getParameter("email"));
		customer.setFirstName(request.getParameter("firstName"));
		customer.setLastName(request.getParameter("lastName"));
		customer.setPassword(request.getParameter("password"));
		customer.setUserName(request.getParameter("userName"));
		customer.setTelephone(request.getParameter("telephone"));
		
		Address address =new Address();
		address.setState(request.getParameter("street"));
		address.setCity(request.getParameter("city"));
		address.setStreet(request.getParameter("state"));
		address.setZipCode(request.getParameter("zipCode"));
		customer.setAddress(address);
		
	
		Account account =new Account();
		account.setAccountType(request.getParameter("accountType"));
		account.setAccountName(request.getParameter("accountName"));
		//account.setId(id);
		String bal= request.getParameter("balance");
		double bal1 = Double.parseDouble(bal);
		account.setBalance(bal1);
		customer.setAccounts(account);
		
		
		HttpSession session = request.getSession(true);
		session.setAttribute("customer", customer);
		
		RequestDispatcher rs= request.getRequestDispatcher("account.jsp");
		rs.forward(request, response);
	}
		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
