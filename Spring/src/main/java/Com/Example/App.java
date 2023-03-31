package Com.Example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	 ApplicationContext ap = new ClassPathXmlApplicationContext("config.xml");
         AgentsDoa Dao=(AgentsDoa)ap.getBean("e");
         
        System.out.println(Dao.saveAgents(new Agents(101,"Sham",10200))); 
         
        System.out.println(Dao.saveAgents(new Agents(102,"Ram",75000))); 
        
        System.out.println(Dao.saveAgents(new Agents(103,"Ramesh",44000))); 

        // Update Method
        System.out.println(Dao.updateAgents(new Agents(1,"Suresh",65000)));
       
     }
}