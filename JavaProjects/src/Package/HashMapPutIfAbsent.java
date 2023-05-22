package Package;
import java.util.HashMap;
import java.util.Map;

public class HashMapPutIfAbsent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Object, Object> fav = new HashMap<>();
		fav.put("Jenny", "Bus Tour");
		fav.put("Tom", null);
		fav.putIfAbsent("Jenny", "Tram");
		fav.putIfAbsent("Sam", "Tram");
		fav.putIfAbsent("Tom", "Tram");
		System.out.println(fav);
	}
}