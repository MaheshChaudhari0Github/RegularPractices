package com.example.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

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

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String SIGNUP_PAGE = "/signup.jsp";
	String SIGNIN_PAGE = "/signin.jsp";
	String SHOWDATA_PAGE = "/show.jsp";
	String EDITDATA_PAGE = "/edit.jsp";

	CustomerService customerService = new CustomerServiceImpl();

	public CustomerController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String redirect = "";
		String custName = request.getParameter("custName");
		String action = request.getParameter("action");
		
		if (action.equals("signup") && custName != null) {
			String custAddress = request.getParameter("custaddress");
			long custNumber = Long.valueOf(request.getParameter("custnumber"));
			double custAccBalance = Double.valueOf(request.getParameter("custaccbalance"));
			Date custDOB = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try {
				custDOB = sdf.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("emppassword");

			Customer customer = new Customer(custName, custAddress, custNumber, custAccBalance, custDOB, custEmailId,
					custPassword);

			customerService.signUp(customer);

			redirect = SIGNIN_PAGE;
		} else if (action.equals("signin")) {
			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("emppassword");
			if (customerService.signIn(custEmailId, custPassword)) {

				request.setAttribute("CustomerList", customerService.getAllData());
				redirect = SHOWDATA_PAGE;
			} else {
				request.setAttribute("message", "Bidu galat dala he");
				redirect = SIGNIN_PAGE;
			}

		} else if (action.equals("edit_form")) {
			redirect = EDITDATA_PAGE;

		} else if (action.equals("edit")) {
			int custId = Integer.parseInt(request.getParameter("custid"));
			String customername = request.getParameter("customername");
			String custAddress = request.getParameter("custaddress");
			long custNumber = Long.valueOf(request.getParameter("custnumber"));
			double custAccBalance = Double.valueOf(request.getParameter("custaccbalance"));
			Date custDOB = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			try {
				custDOB = sdf.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("emppassword");

			Customer customer = new Customer(customername, custAddress, custNumber, custAccBalance, custDOB,
					custEmailId, custPassword);

			customerService.updateData(custId, customer);
			request.setAttribute("CustomerList", customerService.getAllData());
			redirect = SHOWDATA_PAGE;

		} else if (action.equals("sortbyaccbalance")) {
			request.setAttribute("CustomerList", customerService.getAllData().stream()
					.sorted(Comparator.comparingDouble(Customer::getCustAccBalance)).collect(Collectors.toList()));
			redirect = SHOWDATA_PAGE;
		} else if (action.equals("delete")) {
			int custId = Integer.parseInt(request.getParameter("custid"));
			customerService.deleteDataById(custId);

			request.setAttribute("CustomerList", customerService.getAllData());
			redirect = SHOWDATA_PAGE;
		}
		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}