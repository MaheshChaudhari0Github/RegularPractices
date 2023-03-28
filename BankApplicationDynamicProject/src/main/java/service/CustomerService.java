package service;

import java.util.Scanner;

public class CustomerService {

	Scanner sc = new Scanner(System.in);
	int customerAccountBalance = 1000;

	public void deposit() {

		System.out.println("Your Account Balance : " + customerAccountBalance);
		System.out.println("\n Please enter the money you want to deposit");
		int depositmoney = sc.nextInt();

		customerAccountBalance += depositmoney;
		System.out.println("Your Account Balance : " + customerAccountBalance);

	}

	public void withdraw() {
		System.out.println("Your Account Balance : " + customerAccountBalance);
		System.out.println("\n Please enter the money you want to withdraw");
		
		int withdrawmoney = sc.nextInt();
		
		if (customerAccountBalance >= withdrawmoney) {
			System.out.println("Withdraw Sucessfully");
			customerAccountBalance -= withdrawmoney;
			System.out.println("Your Account Balance : " + customerAccountBalance);

		} else {
			System.out.println("Insufficient Balance");
		}
	}

	public void transfer() {
		System.out.println("Your Account Balance : " + customerAccountBalance);
		System.out.println("\n Please enter the money you want to transfer");
		
		int transfermoney=sc.nextInt();
		
		if (customerAccountBalance>=transfermoney) {
			otps();
			customerAccountBalance-=transfermoney;
			System.out.println("Transfer Sucessfully \n Your Account Balance : "+customerAccountBalance);
			
		}else {
			System.out.println("Insufficient Balance");
		}
	}

	public void checkbalance() {

		System.out.println("Your Account Balance : " + customerAccountBalance);

	}

	public static void logouts() {// Static methods

		System.exit(0);
	}
	
	public void otps() {
		int otp = (int) ((Math.random()*900)+1000);
		System.out.println(otp);
		System.out.println("Please Enter Your Otp");
		int returnotp=sc.nextInt();
		
		if (otp==returnotp) {
			System.out.println("Otp Match");
		} else {
			System.out.println("Please try again");
		}
	}
}