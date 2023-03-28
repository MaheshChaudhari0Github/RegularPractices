package Packages;
import java.util.Scanner;
public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Declarations
		String Operator;
		int a,b,c = 0;
		// Scanner input
		Scanner s = new Scanner(System.in);
		// Ask User
		System.out.println("Enter the First Number");
		a = s.nextInt();
	    //  Ask User
		System.out.println("\nChoose Operations: +,-,*,/");
		Operator = s.next();
		// Ask User
		System.out.println("\nEnter the Second Number");
		b = s.nextInt();
		
		switch (Operator)
		{
		// Addition Case
		case "+":
			c = a+b;
		System.out.println("\n" + a+ "+" +b+ "=" +c); 
			break;
		// Subtraction Case
		case "-":
			c = a-b;
		System.out.println("\n" + a+ "-" +b+ "=" +c);
			break;
		// Multiplication Case
		case "*":
			c = a*b;
		System.out.println("\n" + a+ "*" +b+ "=" +c);
			break;	
		// Division Case
		case "/":
			c = a/b;
		System.out.println("\n" + a+ "/" +b+ "=" +c);
			break;	
		}
		s.close();
	}

}
