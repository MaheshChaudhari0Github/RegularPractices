package Com.Employees;

import javax.persistence.Embeddable;
@Embeddable
public class Address {
	
	private String H_name;
	private String Area;
	private String city;
	private int Pincode;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getH_name() {
		return H_name;
	}
	public void setH_name(String h_name) {
		H_name = h_name;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return Pincode;
	}
	public void setPincode(int pincode) {
		Pincode = pincode;
	}
}