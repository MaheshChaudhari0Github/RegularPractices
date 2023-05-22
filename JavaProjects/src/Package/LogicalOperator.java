package Package;

public class LogicalOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 60;
		int b = 40;
		if(a < 50 && b < 50 )
			System.out.println("both less than 50");
		else
			System.out.println("Done");
		if(a < 50 || b < 50)
			System.out.println("Yes it is");
		else
			System.out.println("At least One less than 50");

	}

}
