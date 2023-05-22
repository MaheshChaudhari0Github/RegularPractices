package Package;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class ArrayListClears {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the names of Birds ");
		List <String> birds = new ArrayList<>();
		for (int i=0;i<5;i++)
		{
		String name = sc.next();
		birds.add(name);
		}
		System.out.println(birds);
		birds.clear();
		System.out.println("After using clear function "+ birds);
		sc.close();
	}
}
