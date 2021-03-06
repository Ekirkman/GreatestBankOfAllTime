package com.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Customer;

/**
 * Servlet implementation class WithdrawlServlet
 */
@WebServlet("/WithdrawlServlet2")
public class WithdrawlServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawlServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Customer customer = (Customer)session.getAttribute("customer");
		String withdrawl = request.getParameter("transactionAmount1");
		double withdrawl1= Double.parseDouble(withdrawl);
		//double prevBal = customer.getAccounts().get(0).getBalance();
		//double newBal= prevBal - withdrawl1;
		//customer.getAccounts().get(0).setBalance(newBal);
		
		customer.getAccounts().get(1).credit(withdrawl1);
		session.setAttribute("customer", customer);
		RequestDispatcher rs= request.getRequestDispatcher("secondaryAccount.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
