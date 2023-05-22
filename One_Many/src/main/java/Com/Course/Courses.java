package Com.Course;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Courses {
@Id
	private int C_Id;
	private String C_Name;
	public int getC_Id() {
		return C_Id;
	}
	public void setC_Id(int c_Id) {
		C_Id = c_Id;
	}
	public String getC_Name() {
		return C_Name;
	}
	public void setC_Name(String c_Name) {
		C_Name = c_Name;
	}
	public Courses() {
		
		// TODO Auto-generated constructor stub
	}
	
}
