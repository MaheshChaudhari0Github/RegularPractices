package Package;
//import java.lang.*;
public class CommandLineArgument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float p,r,si;
		int n;
		p=Float.parseFloat(args[0]);
		r=Float.parseFloat(args[1]);
		n=Integer.parseInt(args[2]);
		si=p*n*r/100;
		System.out.println(si);
	}
}
