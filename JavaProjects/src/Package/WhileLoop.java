package Package;
import java.util.Scanner;
public class WhileLoop {

	public static void main(String[] args) {
		// First Method
		int j =1;
		while(j<=5)
		{
			System.out.println(j);
			j = j+1;
		}
		// Second Method
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = sc.nextInt();
		int i = n+1;
		while (i<=10) 
		{
			System.out.println(i);
			i= i+1;
			sc.close();
		}
	}
}
