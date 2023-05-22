package com.example.controller;

import java.io.IOException;
import java.text.ParseException;
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
import com.ibm.icu.text.SimpleDateFormat;


@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String SIGNUP_PAGE = "/signup.jsp";
	String SIGNIN_PAGE = "/signin.jsp";
	String SHOWDATA_PAGE = "/show.jsp";
	
	CustomerService customerServiceImpl = new CustomerServiceImpl();
    
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String redirect =" " ;
		String custName=request.getParameter("custname");
		String action = request.getParameter("action");
		if (custName!= null && action.equals("signup")) {
			
			String custAddress= request.getParameter("custaddress");
			long custNumber = Long.valueOf(request.getParameter("custnumber"));
			double custAccBalance = Double.valueOf(request.getParameter("custaccbalance"));
			String custGender = request.getParameter("custgender");
			Date custDOB = null;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			try {
				custDOB = simpleDateFormat.parse(request.getParameter("custdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");
			
			Customer custmer = new Customer(custName, custAddress, custNumber, custAccBalance, custGender, custDOB, custEmailId, custPassword, false);
			
			customerServiceImpl.signup(custmer);
			redirect = SIGNIN_PAGE;
			
		}else if (action.equals("signin")) {
			
			String custEmailId = request.getParameter("custemailid");
			String custPassword = request.getParameter("custpassword");
			
			if (customerServiceImpl.signin(custEmailId, custPassword)) {
				redirect = SHOWDATA_PAGE;
				request.setAttribute("customerList", customerServiceImpl.getAllData());
			} else {
				request.setAttribute("message", "Please try again");
				redirect = SIGNIN_PAGE;
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}