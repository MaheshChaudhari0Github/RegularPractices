package com.bank;

import java.util.Scanner;

public class Banksystem {

	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in)) {
			long customerAccountNumbers = 123;
			String customerPasswords = "Mahesh123";
			int customerAccountBalance = 1000;
			boolean flag = false;

			do {
				System.out.println("\n Please Enter Your Account Number :");

				long customerAccountNumber = sc.nextLong();
				sc.nextLine();
				String customerPassword = sc.nextLine();

				if (customerAccountNumbers == customerAccountNumber && customerPasswords.equals(customerPassword)) {

					int otp1 = (int) ((Math.random() * 900) + 1000);

					System.out.println(otp1);
					System.out.println("Please Enter Your OTP");

					int otpvalue1 = sc.nextInt();

					if (otp1 == otpvalue1) {
						System.out.println("OTP is Correct");
					} else {
						System.out.println("Invalid otps1");
						System.exit(0);
					}

					System.out.println("\n Welcome To Java Bank");

				} else {
					System.out.println("Invalid Account Number " + "\n");
					flag = true;
				}
			} while (flag);

			do {
				System.out
						.println("\n Please Enter Your Choices :  \n 1. Depoist Money \n 2. Withdraw Money \n 3. Transfer "
								+ "\n 4. Check Account Balance  \n 5. Exit");
				int choice = sc.nextInt();
				switch (choice) {

				case 1:

					System.out.println("Your Account Balance = " + customerAccountBalance);
					System.out.println("Please Enter the Amount You Want to Deposit");

					int customerAccountDepositValue = sc.nextInt();
					customerAccountBalance = customerAccountDepositValue + customerAccountBalance;
					System.out.println("Your Account Balance " + customerAccountBalance);

					break;

				case 2:

					System.out.println("Your Account Balance = " + customerAccountBalance);
					System.out.println("Please Enter the Amount You Want to Withdraw");

					int customerAccountWithdrawValue = sc.nextInt();
					customerAccountBalance = customerAccountBalance - customerAccountWithdrawValue;
					System.out.println("Your Account Balance " + customerAccountBalance);

					break;

				case 3:

					System.out.println("Your Account Balance = " + customerAccountBalance);
					System.out.println("Enter the Amount : ");

					int customerAccountTransferValue = sc.nextInt();

					if (customerAccountBalance > customerAccountTransferValue) {

						int otp = (int) ((Math.random() * 900) + 1000);

						System.out.println(otp);
						System.out.println("Please Enter Your OTP");

						int otpvalue = sc.nextInt();

						if (otp == otpvalue) {
							System.out.println("OTP is Correct");

							customerAccountBalance = customerAccountBalance - customerAccountTransferValue;

							System.out.println("Transfer Sucessfully");
							System.out.println("Your Account Balance " + customerAccountBalance);

						} else {
							System.out.println("Invalid OTP");

						}
					} else {
						System.out.println("Insufficient Funds");
					}

					break;

				case 4:

					System.out.println("Your Account Balance " + customerAccountBalance);

					break;

				case 5:

					System.exit(0);
					System.out.println("Exit Sucessfully !");

					break;

				default:

					System.out.println("Invald Choice");
					break;

				}

			} while (true);
		}
	}
}