package Package;

import java.util.LinkedList;

public class LinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList <String> Cars = new LinkedList <String>();
		Cars.add("Volvo");
		Cars.add("Ford");
		Cars.add("Audi");
		Cars.add("Tesla");
		Cars.add("BMW");
		Cars.addFirst("Honda");
		Cars.addLast("TATA");
		// print in one line
		System.out.println(Cars);
	}
}
