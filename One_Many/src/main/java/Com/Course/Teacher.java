package Com.Course;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Course_T")
public class Teacher {
@Id
	private int T_id;
	private String T_Name;
	private String T_Department;
	public int getT_id() {
		return T_id;
	}
	public void setT_id(int t_id) {
		T_id = t_id;
	}
	public String getT_Name() {
		return T_Name;
	}
	public void setT_Name(String t_Name) {
		T_Name = t_Name;
	}
	public String getT_Department() {
		return T_Department;
	}
	public void setT_Department(String t_Department) {
		T_Department = t_Department;
	}
	public Teacher() {
		
		// TODO Auto-generated constructor stub
		
		
	}
	@OneToMany(cascade = CascadeType.ALL)
	List<Courses> cousres;
	public List<Courses> getCousres() {
		return cousres;
	}
	public void setCousres(List<Courses> cousres) {
		this.cousres = cousres;
	}
	
}
