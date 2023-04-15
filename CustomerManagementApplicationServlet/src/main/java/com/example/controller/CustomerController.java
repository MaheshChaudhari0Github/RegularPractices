package com.example.controller;

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

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String SIGNUP_PAGE = "/signup.jsp";
	String SIGNIN_PAGE = "/signin.jsp";
	String SHOWDATA_PAGE = "/show.jsp";
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
			int custid = Integer.parseInt(customerId);
			String custName = request.getParameter("custname");
			String custAddress = request.getParameter("custaddress");
			long custNumber = Long.valueOf(request.getParameter("custnumber"));
			double custAccBalance = Double.valueOf(request.getParameter("custaccbalance"));
			int custAge = Integer.parseInt(request.getParameter("custage"));
			Date custdobDate = null;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			try {
				custdobDate = simpleDateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(custid, custName, custAddress, custNumber, custAccBalance, custAge,
					custdobDate, custEmailId, custPassword);

			customerServiceImpl.signUP(customer);

			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {
			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");

			if (customerServiceImpl.signIn(custEmailId, custPassword)) {
				request.setAttribute("customerList", customerServiceImpl.findAll());
				redirect = SHOWDATA_PAGE;
			} else {
				request.setAttribute("message", "Bidu fir sea try kar !");
				redirect = SIGNIN_PAGE;
			}

		} else if (action.equals("edit_form")) {
			redirect = EDITDATA_PAGE;
		} else if (action.equals("edit")) {

			int custid = Integer.parseInt(request.getParameter("custid"));
			String custName = request.getParameter("custname");
			String custAddress = request.getParameter("custaddress");
			long custNumber = Long.valueOf(request.getParameter("custnumber"));
			double custAccBalance = Double.valueOf(request.getParameter("custaccbalance"));
			int custAge = Integer.parseInt(request.getParameter("custage"));
			Date custdobDate = null;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			try {
				custdobDate = simpleDateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");

			Customer customer = new Customer(custid, custName, custAddress, custNumber, custAccBalance, custAge,
					custdobDate, custEmailId, custPassword);

			customerServiceImpl.updateData(custid, customer);
			request.setAttribute("customerList", customerServiceImpl.findAll());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("delete")) {

			int custid = Integer.parseInt(request.getParameter("custid"));

			customerServiceImpl.deleteDataById(custid);
			request.setAttribute("customerList", customerServiceImpl.findAll());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("deletealldata")) {
			customerServiceImpl.deleteAllData();
			request.setAttribute("customerList", customerServiceImpl.findAll());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyage")) {
			request.setAttribute("customerList", customerServiceImpl.sortByAge());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyname")) {
			request.setAttribute("customerList", customerServiceImpl.sortByName());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbydob")) {
			request.setAttribute("customerList", customerServiceImpl.sortByCustDOB());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyaccbalance")) {
			request.setAttribute("customerList", customerServiceImpl.sortByAccBalance());
			redirect = SHOWDATA_PAGE;
		} else if (action.equals("filterbyid")) {
			int custid = Integer.parseInt(request.getParameter("custid"));
			List<Customer> customers = new ArrayList<Customer>();
			customers.add(customerServiceImpl.getDataById(custid));
			request.setAttribute("customerList", customers);
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("filterbyname")) {

			String custName = request.getParameter("custname");

			request.setAttribute("customerList", customerServiceImpl.filterByName(custName));
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("filterbyemail")) {
			String custEmailId = request.getParameter("custemailid");
			List<Customer> customers = new ArrayList<Customer>();
			customers.add(customerServiceImpl.filterByEmailId(custEmailId));
			request.setAttribute("customerList", customers);
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