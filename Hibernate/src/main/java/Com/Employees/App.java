package Com.Employees;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.internal.build.AllowSysOut;

public class App 
{
	public static String addEmployee(Session s ,Transaction T)
	{
		System.out.println("Enter E_id:");
		Scanner sc1=new Scanner(System.in);
		int E_id=sc1.nextInt();
		
		System.out.println("Enter the Name:");
		Scanner sc2=new Scanner(System.in);
		String E_name=sc2.nextLine();
		
		System.out.println("Enter Department:");
		Scanner sc3=new Scanner(System.in);
		String Department=sc3.nextLine();
		
		System.out.println("Enter Salary: ");
		Scanner sc4=new Scanner(System.in);
		int Salary=sc4.nextInt();
				
		Scanner sc5=new Scanner(System.in);
		System.out.println("Enter the Employee Home Name :");
		String H_name=sc5.nextLine();
		
		Scanner sc6=new Scanner(System.in);
		System.out.println("Enter the Employee Area :");
		String Area=sc6.nextLine();
		
		Scanner sc7=new Scanner(System.in);
		System.out.println("Enter the Employee City :");
		String City=sc7.nextLine();
		
		Scanner sc8=new Scanner(System.in);
		System.out.println("Enter the Employee Pincode :");
		int Pincode=sc8.nextInt();
		
		Address ad = new Address();
		ad.setH_name(H_name);
		ad.setArea(Area);
		ad.setCity(City);
		ad.setPincode(Pincode);
				
		Employee E = new Employee();
		E.setE_id(E_id);
		E.setE_name(E_name);
		E.setDepartment(Department);
		E.setSalary(Salary);
		E.setAddress(ad);
		s.save(E);
		T.commit();
		
		sc1.close();
		sc2.close();
		sc3.close();
		sc4.close();
		sc5.close();
		sc6.close();
		sc7.close();
		sc8.close();
		return "Employee Added Succesfuly";	
	}
    public static void main( String[] args )
    {
        System.out.println( "Project Started!" );
        Configuration cfg=new Configuration().configure().addAnnotatedClass(Employee.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction T = s.beginTransaction();
        
        System.out.println("Enter Username: ");
        Scanner ssc=new Scanner(System.in);
        String Username=ssc.nextLine();
        if(Username.equals("Punam"))
        {
        	System.out.println("Enter Your Password: ");
        	Scanner ssc2=new Scanner(System.in);
        	String password=ssc2.nextLine();
        	
        	if(password.equals("1214"))
        	{        		       		
        			System.out.println("Enter the option 1.Add Employee");
        			Scanner ss1=new Scanner(System.in);
        			int entry=ss1.nextInt();
        			if(entry==1)
        			{
        				System.out.println(addEmployee(s,T ));
        			}
        			ss1.close();
        	}
        	else
        	{
        		System.out.println("Incorrect Password!!");
        	}
        	ssc2.close();
        }
        else {
        	System.out.println("Incorrect Username!!");
        }ssc.close();
    }
}