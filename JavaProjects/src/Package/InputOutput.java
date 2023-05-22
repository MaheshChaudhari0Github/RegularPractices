package Package;
import java.util.Scanner;
public class InputOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method Stub
		Scanner var = new Scanner(System.in);
		// printf
		System.out.println("Enter your Age :  ");
		// Scanf
		int age = var.nextInt();
		System.out.println(age);
		// To print name
		System.out.println("Enter your Name :  ");
		// Print only 1St word
		String name = var.next();
		System.out.println(name);
		// Whole line print (comment all over for whole lie)
		name = var.nextLine();
		System.out.println(name);
		// To close the Scanner
		var.close();
	}

}
