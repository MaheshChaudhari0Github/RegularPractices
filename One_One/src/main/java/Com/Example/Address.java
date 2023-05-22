package Com.Example;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="A_Address")
public class Address implements Serializable {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)

	private int A_Id,Pincode;
	public Employee getE1() {
	return E1;
}

	private String H_Name,Area,City;
	public int getA_Id() {
		return A_Id;
	}
	public void setA_Id(int a_Id) {
		A_Id = a_Id;
	}
	public int getPincode() {
		return Pincode;
	}
	public void setPincode(int pincode) {
		Pincode = pincode;
	}
	public String getH_Name() {
		return H_Name;
	}
	public void setH_Name(String h_Name) {
		H_Name = h_Name;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public void setE1(Employee e1) {
		E1 = e1;
	}
	public Address() {
	
		// TODO Auto-generated constructor stub
	}
	@OneToOne(targetEntity = Employee.class)
	private Employee E1;
	

}
