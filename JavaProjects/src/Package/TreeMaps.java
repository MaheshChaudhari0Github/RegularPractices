package Package;
import java.util.TreeMap;
public class TreeMaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer,String> employee = new TreeMap<>();
		employee.put(4, "Pratik");
		employee.put(2, "Saurabh");
		employee.put(5, "Suraj");
		employee.put(6, "Mahesh");
		employee.put(1, "Divyesh");
		employee.put(3, "Prajwal");
		//Print in one line
		// System.out.println(employee);
		for (Integer P: employee.keySet())
			System.out.println("employeeID"+P+"Employee Name"+ employee.get(P) );
		//for (Integer P : employee.keySet())
			//System.out.println(employee.descendingMap());
		
		//for (Integer T: employee.key());
		//System.out.println(employee.subMap(2, 4));	
	}
}
