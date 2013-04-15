import java.util.ArrayList;


public class trytry {
	int x;
	int y;
	char z;

	public static void main(String args[]) {
		G<Integer> g = new G<Integer>(10, 5, new Integer(1));

		// g.set(new Integer(5));			

		System.out.println(g.x);
		System.out.println(g.z);
		ArrayList<Integer> list = g.addto(new Integer(3));

		for (Integer in : list)
			System.out.println(in);
	}

}

class G<T> {
	public int x;
	public int y;
	T z;
	
	public G (int x, int y, T z) {
        this.x = x;
		this.y = y;
		this.z = z;
    }

	public void set(T z) {
		this.z = z;
	}

	public ArrayList<T> addto(T m) {
		ArrayList<T> list = new ArrayList<T>();

		list.add(m);
		list.add(m);
		list.add(m);

		return list;
	}
}
