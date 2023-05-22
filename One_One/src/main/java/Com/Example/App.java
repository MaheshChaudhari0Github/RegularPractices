package Com.Example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Configuration cfg=new Configuration().configure().addAnnotatedClass(Employee.class);
        Configuration cfg1=new Configuration().configure().addAnnotatedClass(Address.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction T = s.beginTransaction();
        
        Employee E1 = new Employee();
        E1.setE_Id(101);
        E1.setE_Name("Shamu");
        E1.setE_Salary(4100);
        E1.setDepartment("Mainubit");
        
        Address A1 = new Address();
        A1.setA_Id(111);
        A1.setH_Name("ShamSundarm");
        A1.setArea("PimpriC");
        A1.setCity("Pune");
        A1.setPincode(14);
        
       E1.setA1(A1);
       A1.setE1(E1);
       //s.persist(E1);
       s.save(E1);
       T.commit();
       
        
        
        
    }
}
