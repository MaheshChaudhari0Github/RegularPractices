package Package;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class StackPushPop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		list.add(new String ("Mahesh"));
		Stack<String> v = new Stack<>();
		v.push("Saurabh");
		v.push("Suraj");
		v.push("Divyesh");
		v.push("Prajwal");
		v.pop();
		v.pop();
		// First in First Out
		Iterator<String> itr =v.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}	
	}
}
