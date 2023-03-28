package controller;

import java.util.Scanner;

import model.Customer;
import service.CustomerService;

public class CustomerController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerService customerserviceobj = new CustomerService();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the Account Number and Password");

			boolean status = true;

			do {

				long customerAccountNumber = sc.nextLong();
				String customerPassword = sc.next();

				Customer customer = new Customer(123, "Mahesh@123");

				if (customer.getCustomerAccountNumber() == customerAccountNumber
						&& customer.getCustomerPassowrd().equals(customerPassword)) {
					System.out.println("WELCOME TO JAVA BANK");
					status = false;
				} else {
					System.out.println("Please try again");
				}

			} while (status);

			do {

				System.out.println(
						"\n Please enter your choice \n 1. Deposit \n 2. Withdraw \n 3. Transfer \n 4. Check Your Balance \n 5. Exit");
				

				int choice = sc.nextInt();

				switch (choice) {
				
				case 1:
					
					customerserviceobj.deposit();
					
					break;
				case 2:
					
					customerserviceobj.withdraw();

					break;
				case 3:
					customerserviceobj.transfer();

					break;
				case 4:
					customerserviceobj.checkbalance();

					break;
				case 5:
					CustomerService.logouts();
					//customerserviceobj.logouts();
					break;
				default:
					break;
				}
			} while (true);
		}
	}
}