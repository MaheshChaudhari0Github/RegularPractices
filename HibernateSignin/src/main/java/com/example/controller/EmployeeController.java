package com.example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String SIGNUP_PAGE = "/signup.jsp";
	String SIGNIN_PAGE = "/signin.jsp";
	String WELCOME_PAGE = "/welcome.jsp";

	EmployeeService employeeServiceImpl = new EmployeeServiceImpl();

	/**
	 * Default constructor.
	 */
	public EmployeeController() {
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
		String empName = request.getParameter("empname");
		String action = request.getParameter("action");

		if (empName != null && action.equals("signup")) {

			String empAddress = request.getParameter("empaddress");
			long empNumber = Long.valueOf(request.getParameter("empnumber"));
			String empEmailId = request.getParameter("empemailid");
			String empPassword = request.getParameter("emppassword");

			Employee employee = new Employee(empName, empAddress, empNumber, empEmailId, empPassword);

			employeeServiceImpl.signup(employee);

			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {

			String empEmailId = request.getParameter("empemailid");
			String empPassword = request.getParameter("emppassword");

			if (employeeServiceImpl.signin(empEmailId, empPassword)) {
				redirect = WELCOME_PAGE;

			} else {
				request.setAttribute("message", "Bidu fir sea try kar");
				redirect = SIGNIN_PAGE;
			}

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