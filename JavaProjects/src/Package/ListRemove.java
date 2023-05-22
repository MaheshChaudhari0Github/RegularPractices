package Package;

import java.util.ArrayList;
import java.util.List;

public class ListRemove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> Cars = new ArrayList<>();
		Cars.add("BMW");
		Cars.add("Volvo");
		Cars.add("Ford");
		Cars.add("Audi");
		Cars.add("Tesla");
		// All List Print
		System.out.println(Cars);
		// Remove function
		Cars.remove(2);
		System.out.println(Cars.remove("BMW"));
		System.out.println(Cars);
	}
}
