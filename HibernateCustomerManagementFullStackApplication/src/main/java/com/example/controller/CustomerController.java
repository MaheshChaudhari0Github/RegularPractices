package com.example.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * Servlet implementation class customerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String SIGNUP_PAGE = "/signup.jsp";
	String SIGNIN_PAGE = "/signin.jsp";
	String EDITDATA_PAGE = "/edit.jsp";
	String SHOWDATA_PAGE = "/show.jsp";

	CustomerService customerServiceImpl = new CustomerServiceImpl();

	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String redirect = "";
		String custName = request.getParameter("custname");
		String action = request.getParameter("action");

		if (action.equals("signup") && custName != null) {

			String custAddress = request.getParameter("custaddress");
			long custNumber = Long.valueOf(request.getParameter("custnumber"));
			double custAccBalance = Double.valueOf(request.getParameter("custaccbalance"));
			String custGender = request.getParameter("custgender");

			Date custDob = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try {
				custDob = sdf.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO: handle exception
			}

			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(custName, custAddress, custNumber, custAccBalance, custGender, custDob,
					custEmailId, custPassword);

			customerServiceImpl.signup(customer);
			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {

			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");

			if (customerServiceImpl.signin(custEmailId, custPassword)) {
				request.setAttribute("customerList", customerServiceImpl.getAllData());
				redirect = SHOWDATA_PAGE;
			} else {
				request.setAttribute("message", "Bidu fir se try kar!");
				redirect = SIGNIN_PAGE;
			}
		} else if (action.equals("edit_form")) {
			redirect = EDITDATA_PAGE;

		} else if (action.equals("edit")) {
			int custId = Integer.parseInt(request.getParameter("custid"));
			String customerName = request.getParameter("custname");
			String custAddress = request.getParameter("custaddress");
			long custNumber = Long.valueOf(request.getParameter("custnumber"));
			double custAccBalance = Double.valueOf(request.getParameter("custaccbalance"));
			String custGender = request.getParameter("custgender");

			Date custDob = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try {
				custDob = sdf.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO: handle exception
			}

			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(customerName, custAddress, custNumber, custAccBalance, custGender, custDob,
					custEmailId, custPassword);

			customerServiceImpl.updateData(custId, customer);
			request.setAttribute("customerList", customerServiceImpl.getAllData());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("delete")) {

			int custId = Integer.parseInt(request.getParameter("custid"));
			customerServiceImpl.deleteDataById(custId);
			request.setAttribute("customerList", customerServiceImpl.getAllData());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("deletealldata")) {

			customerServiceImpl.deleteAllData();
			request.setAttribute("customerList", customerServiceImpl.getAllData());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyname")) {

			request.setAttribute("customerList", customerServiceImpl.sortByCustName());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyaccbalance")) {

			request.setAttribute("customerList", customerServiceImpl.sortByAccBalance());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbydob")) {

			request.setAttribute("customerList", customerServiceImpl.sortByDob());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("filterbyname")) {

			String customerName = request.getParameter("custname");

			request.setAttribute("customerList", customerServiceImpl.filterByName(customerName));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("filterbyaccbalance")) {

			double custAccBalance = Double.valueOf(request.getParameter("custaccbalance"));

			request.setAttribute("customerList", customerServiceImpl.filterByAccBalance(custAccBalance));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("filterbyid")) {

			int custId = Integer.parseInt(request.getParameter("custid"));
			List<Customer> customers = new ArrayList<Customer>();
			customers.add(customerServiceImpl.getDataById(custId));
			request.setAttribute("customerList", customers);
			redirect = SHOWDATA_PAGE;
		}

		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}