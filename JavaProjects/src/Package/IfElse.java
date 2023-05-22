package Package;
import java.util.Scanner;
public class IfElse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int age = 30;
		if (age>18)
			System.out.println("Can vote");
		else
			System.out.println("Can't vote");
		// Second Method (Intger)
		// Scanner sc = new Scanner(System.in);
		int ages;
		System.out.println("Enter the age: ");
		ages = sc.nextInt();
		if (ages>18)
			System.out.println("Can vote");
		else
			System.out.println("Can't vote");
		// Third Method
		Scanner S = new Scanner(System.in);
		String name="Mahesh",names;
		System.out.println("Enter the names: ");
		names = S.next();
		if (name==names)
			//names.equals(S);
			System.out.println("Match");
		else
			System.out.println("Not match");
			//Fourth Method
		Scanner Si = new Scanner(System.in);
		String Name;
		System.out.println("Enter the Name: ");
		Name = Si.next();
		if (Name=="Ram")
			System.out.println("Match");
		else 
			System.out.println("Not match");
		sc.close();
		S.close();
		Si.close();
	}

}
