package Packages;
import java.util.Scanner;
public class RandomNumber {
/* Guess the random number program
	*Range(1-100)*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Mini Project
		Scanner sc = new Scanner(System.in);
		int myNumber = (int)(Math.random()*100);
		int userNumber = 0;
		
		do 
		{
			System.out.println("Guess the number : ");
			userNumber = sc.nextInt();
			
			if(userNumber == myNumber)
			{
				System.out.println("YES .... cORRECT NUMBER !!");
				break;
			}
			else if(userNumber > myNumber)
			{
				System.out.println("Number is too Large");
			}
			else 
			{
				System.out.println("Number is too Small");
			}
		}
			while (userNumber >= 0);
			System.out.println("My number was : ");
			System.out.println(myNumber);
			sc.close();
		
	}
}
