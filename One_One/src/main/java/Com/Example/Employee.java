package Com.Example;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Empol")
public class Employee implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@PrimaryKeyJoinColumn
	private int E_Id;
	private String E_Name;
	private int E_Salary;
	private String Department;
	
	public int getE_Id() {
		return E_Id;
	}
	public void setE_Id(int e_Id) {
		E_Id = e_Id;
	}
	public int getE_Salary() {
		return E_Salary;
	}
	public void setE_Salary(int e_Salary) {
		E_Salary = e_Salary;
	}
	public String getE_Name() {
		return E_Name;
	}
	public void setE_Name(String e_Name) {
		E_Name = e_Name;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public Employee() {
		
		// TODO Auto-generated constructor stub
	}
	@OneToOne(targetEntity = Address.class,cascade=CascadeType.ALL)
		private Address A1;

	public Address getA1() {
		return A1;
	}
	public void setA1(Address a1) {
		A1 = a1;
	}
	
}
