package Package;

import java.util.TreeSet;

public class TreeSets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> num = new TreeSet<>();
		num.add(34);
		num.add(45);
		num.add(65);
		num.add(78);
		num.add(23);
		num.add(87);
		num.add(32);
		//print in one line
		System.out.println(num+"\n");
		// print one under one
		for (Integer n:num)
		{
			System.out.println(n);
		}

	}

}
