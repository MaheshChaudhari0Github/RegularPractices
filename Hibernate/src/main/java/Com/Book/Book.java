package Com.Book;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOK_I")
public class Book {
	@Id
	private int B_id;
	private String B_Name;
	private String A_Name;
	private int Price;
	public Book() {
		
		// TODO Auto-generated constructor stub
	}
	public int getB_id() {
		return B_id;
	}
	public void setB_id(int b_id) {
		B_id = b_id;
	}
	public String getB_Name() {
		return B_Name;
	}
	public void setB_Name(String b_Name) {
		B_Name = b_Name;
	}
	public String getA_Name() {
		return A_Name;
	}
	public void setA_Name(String a_Name) {
		A_Name = a_Name;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	
	
}
