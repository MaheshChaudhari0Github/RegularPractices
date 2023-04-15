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

	String INDEX_PAGE = "/index.jsp";
	String SIGNUP_Page = "/signup.jsp";
	String SIGNIN_PAGE = "/signin.jsp";
	String WELCOME_PAGE = "/welcome.jsp";

	EmployeeService employeeServiceImpl = new EmployeeServiceImpl();

	// Default constructor
	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String redirect = "";

		String employeeId = request.getParameter("empid");
		String action = request.getParameter("action");

		if (employeeId != null && action.equals("signup")) {

			int empId = Integer.parseInt(employeeId);

			String empName = request.getParameter("empname");

			String empAddress = request.getParameter("empaddress");

			double empSalary = Double.valueOf(request.getParameter("empsalary"));

			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			Employee employee = new Employee(empId, empName, empAddress, empSalary, empEmailId, empPassword);
			employeeServiceImpl.signUp(employee);

			redirect = SIGNIN_PAGE;

			System.out.println("Redirected to Sign In Page");

		} else if (action.equals("signin")) {

			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			if (employeeServiceImpl.signIn(empEmailId, empPassword)) {
				redirect = WELCOME_PAGE;
			} else {
				redirect = SIGNIN_PAGE;
			}
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(redirect);
		requestDispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
