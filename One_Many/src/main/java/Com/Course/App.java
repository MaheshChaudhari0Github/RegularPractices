package Com.Course;

import java.util.ArrayList;
import java.util.List;

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
        Configuration cfg=new Configuration().configure().addAnnotatedClass(Teacher.class);
        Configuration cfg1=new Configuration().configure().addAnnotatedClass(Courses.class);
        SessionFactory sf=cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction T = s.beginTransaction();
        
        Teacher T1 = new Teacher();
        T1.setT_id(103);
        T1.setT_Name("Amarpali");
        T1.setT_Department("Masters");
        
        Courses c1 = new Courses();
        Courses c2 = new Courses();
        Courses c3 = new Courses();
        
        c1.setC_Id(10001);
        c1.setC_Name("Java Training");
        
        c2.setC_Id(10002);
        c2.setC_Name("Python Training");
        
        c3.setC_Id(10003);
        c3.setC_Name("Angular Training");
        
        List<Courses> c11 = new ArrayList();
        
        c11.add(c1);
        c11.add(c2);
        c11.add(c3);
        
        T1.setCousres(c11);
        s.persist(T1);
        T.commit();
        s.close();
        
           
    }
}
