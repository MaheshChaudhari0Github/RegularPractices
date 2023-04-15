package com.example.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String SIGNUP_PAGE = "/signup.jsp";
	String SIGNIN_PAGE = "/signin.jsp";
	String SHOWDATA_PAGE = "/show.jsp";
	
	CustomerService customerServiceImpl = new CustomerServiceImpl();

	public CustomerController() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String redirect = "";

		String customerId = request.getParameter("custid");
		String action = request.getParameter("action");

		if (customerId != null && action.equals("signup")) {
			
			int custId = Integer.parseInt(customerId);
			String custName = request.getParameter("custname");
			String custAddress = request.getParameter("custaddress");
			long custNumber = Long.valueOf(request.getParameter("custnumber"));
			double custAccBalance = Double.valueOf(request.getParameter("custaccbalance"));
			int custAge = Integer.parseInt(request.getParameter("custage"));
			Date dobDate = null;

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			try {
				dobDate = simpleDateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(custId, custName, custAddress, custNumber, custAccBalance, custAge,
					dobDate, custEmailId, custPassword);

			customerServiceImpl.signUp(customer);
			redirect = SIGNIN_PAGE;

			System.out.println("Redirect to Sign in page");
		} else if (action.equals("signin")) {

			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");

			if (customerServiceImpl.signIn(custEmailId, custPassword)) {
				request.setAttribute("customerList", customerServiceImpl.findAll());
				redirect = SHOWDATA_PAGE;
			} else {
				redirect = SIGNIN_PAGE;
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}