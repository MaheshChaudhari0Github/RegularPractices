package com.csi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csi.model.Customer;
import com.csi.service.CustomerService;
import com.csi.service.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String SIGNUP_PAGE = "/signup.jsp";
	String SIGNIN_PAGE = "/signin.jsp";
	String SHOWWDATA_PAGE = "/show.jsp";
	String EDITDATA_PAGE = "/edit.jsp";

	CustomerService customerServiceImpl = new CustomerServiceImpl();

	public CustomerController() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String redirect = "";

		String customerId = request.getParameter("custid");

		String action = request.getParameter("action");

		if (customerId != null && action.equals("signup")) {

			int custId = Integer.parseInt(customerId);

			String custName = request.getParameter("custname");

			String custAddress = request.getParameter("custaddress");

			long custContactNumber = Long.valueOf(request.getParameter("custcontactnumber"));

			double custAccountBalance = Double.valueOf(request.getParameter("custaccountbalance"));

			int custAge = Integer.parseInt(request.getParameter("custage"));

			Date custDOBDate = null;

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			try {
				custDOBDate = simpleDateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String custEmailId = request.getParameter("custemailid");

			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(custId, custName, custAddress, custContactNumber, custAccountBalance,
					custAge, custDOBDate, custEmailId, custPassword);

			customerServiceImpl.signUp(customer);

			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {

			String custEmailId = request.getParameter("custemailid");

			String custPassword = request.getParameter("custpassword");

			if (customerServiceImpl.signIn(custEmailId, custPassword)) {
				request.setAttribute("customerList", customerServiceImpl.findAll());
				redirect = SHOWWDATA_PAGE;
			} else {
				request.setAttribute("message", "Oops please try again Invalid Username or Password!!!!!!");
				redirect = SIGNIN_PAGE;
			}

		} else if (action.equals("edit_form")) {
			redirect = EDITDATA_PAGE;
		} else if (action.equals("edit")) {

			int custId = Integer.parseInt(request.getParameter("custid"));

			String custName = request.getParameter("custname");

			String custAddress = request.getParameter("custaddress");

			long custContactNumber = Long.valueOf(request.getParameter("custcontactnumber"));

			double custAccountBalance = Double.valueOf(request.getParameter("custaccountbalance"));

			int custAge = Integer.parseInt(request.getParameter("custage"));

			Date custDOBDate = null;

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			try {
				custDOBDate = simpleDateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String custEmailId = request.getParameter("custemailid");

			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(custId, custName, custAddress, custContactNumber, custAccountBalance,
					custAge, custDOBDate, custEmailId, custPassword);

			customerServiceImpl.updateData(custId, customer);

			request.setAttribute("customerList", customerServiceImpl.findAll());
			redirect = SHOWWDATA_PAGE;

		} else if (action.equals("delete")) {

			int custId = Integer.parseInt(request.getParameter("custid"));

			customerServiceImpl.deleteDataById(custId);

			request.setAttribute("customerList", customerServiceImpl.findAll());
			redirect = SHOWWDATA_PAGE;

		} else if (action.equals("deletealldata")) {

			customerServiceImpl.deleteAllData();
			request.setAttribute("customerList", customerServiceImpl.findAll());
			redirect = SHOWWDATA_PAGE;

		} else if (action.equals("sortbyage")) {

			request.setAttribute("customerList", customerServiceImpl.sorByAge());
			redirect = SHOWWDATA_PAGE;

		} else if (action.equals("sortbyname")) {

			request.setAttribute("customerList", customerServiceImpl.sorByName());
			redirect = SHOWWDATA_PAGE;

		} else if (action.equals("sortbydob")) {
			request.setAttribute("customerList", customerServiceImpl.sorByCustDOB());
			redirect = SHOWWDATA_PAGE;

		} else if (action.equals("sortbyaccountbalance")) {
			request.setAttribute("customerList", customerServiceImpl.sorAccBalance());
			redirect = SHOWWDATA_PAGE;
		} else if (action.equals("filterbyid")) {

			int custId = Integer.parseInt(request.getParameter("custid"));

			List<Customer> customers = new ArrayList<Customer>();

			customers.add(customerServiceImpl.getDataById(custId));

			request.setAttribute("customerList", customers);
			redirect = SHOWWDATA_PAGE;

		} else if (action.equals("filterbyname")) {

			String custName = request.getParameter("custname");

			request.setAttribute("customerList", customerServiceImpl.filterByName(custName));

			redirect= SHOWWDATA_PAGE;

		} else if (action.equals("filterbyemail")) {

			String custEmailId = request.getParameter("custemailid");

			List<Customer> customers = new ArrayList<Customer>();

			customers.add(customerServiceImpl.filterByEmailId(custEmailId));

			request.setAttribute("customerList", customers);
			redirect = SHOWWDATA_PAGE;

		} else if (action.equals("filterbyaccountbalance")) {

			double custAccountBalance = Double.valueOf(request.getParameter("custaccountbalance"));

			request.setAttribute("customerList", customerServiceImpl.filterByAccBalance(custAccountBalance));

			redirect= SHOWWDATA_PAGE;
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(redirect);
		requestDispatcher.forward(request, response);
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
