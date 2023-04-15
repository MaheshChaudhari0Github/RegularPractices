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
	String EDITDATA_PAGE = "/edit.jsp";

	CustomerService customerServiceImpl = new CustomerServiceImpl();

	// Default constructor
	public CustomerController() {
		// TODO Auto-generated constructor stub

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String redirect = "";

		String customerId = request.getParameter("custid");
		String action = request.getParameter("action");

		if (customerId != null && action.equals("signup")) {

			int custId = Integer.parseInt(customerId);
			String custAddress = request.getParameter("custaddress");
			String custName = request.getParameter("custname");
			long custNumber = Long.valueOf(request.getParameter("custnumber"));
			double custAccBalance = Double.valueOf(request.getParameter("custaccbalance"));
			int custAge = Integer.parseInt(request.getParameter("custage"));
			Date dobDate = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			try {
				dobDate = dateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(custId, custName, custAddress, custNumber, custAccBalance, custAge,
					dobDate, custEmailId, custPassword);

			customerServiceImpl.signUP(customer);

			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {

			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");
			
			if (customerServiceImpl.signIn(custEmailId, custPassword)) {
				request.setAttribute("customerList", customerServiceImpl.findAll());
				redirect = SHOWDATA_PAGE;
			} else {
				request.setAttribute("message", "Please try again");
				redirect = SIGNIN_PAGE;
			}

		} else if (action.equals("edit_form")) {
			redirect = EDITDATA_PAGE;
		} else if (action.equals("edit")) {

			int custId = Integer.parseInt(request.getParameter("custid"));
			String custAddress = request.getParameter("custaddress");
			String custName = request.getParameter("custname");
			long custNumber = Long.valueOf(request.getParameter("custnumber"));
			double custAccBalance = Double.valueOf(request.getParameter("custaccbalance"));
			int custAge = Integer.parseInt(request.getParameter("custage"));
			Date dobDate = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			try {
				dobDate = dateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(custId, custName, custAddress, custNumber, custAccBalance, custAge,
					dobDate, custEmailId, custPassword);

			customerServiceImpl.updateData(custId, customer);

			request.setAttribute("customerList", customerServiceImpl.findAll());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("delete")) {

			int custId = Integer.parseInt(request.getParameter("custid"));
			customerServiceImpl.deleteDataById(custId);

			request.setAttribute("customerList", customerServiceImpl.findAll());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("deletealldata")) {

			customerServiceImpl.deleteAllData();
			request.setAttribute("customerList", customerServiceImpl.findAll());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyname")) {

			request.setAttribute("customerList", customerServiceImpl.sortByName());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyaccbalance")) {

			request.setAttribute("customerList", customerServiceImpl.sortByAccBalance());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbydob")) {

			request.setAttribute("customerList", customerServiceImpl.sortByCustDOB());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyage")) {

			request.setAttribute("customerList", customerServiceImpl.sortByAge());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("filterbyid")) {

			int custId = Integer.parseInt(request.getParameter("custid"));
			request.setAttribute("customerList", customerServiceImpl.getDataById(custId));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("filterbyname")) {

			String custName = request.getParameter("custname");
			request.setAttribute("customerList", customerServiceImpl.filterByName(custName));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("filterbyemail")) {

			String custEmailId = request.getParameter("custemailid");
			request.setAttribute("customerList", customerServiceImpl.filterByEmailId(custEmailId));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("filterbyaccbalance")) {

			double custAccBalance = Double.valueOf(request.getParameter("custaccbalance"));
			request.setAttribute("customerList", customerServiceImpl.filterByAccBalance(custAccBalance));
			redirect = SHOWDATA_PAGE;

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