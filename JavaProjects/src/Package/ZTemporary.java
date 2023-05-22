package Package;



public class ZTemporary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float num1,num2;
		
		if (args.length!=0)
		{
			num1 = Float.parseFloat(args[0]);
			num2 = Float.parseFloat(args[1]);
			System.out.println("sum of input numbers -");
			System.out.println(num1 + num2);
		}	
	}
}
