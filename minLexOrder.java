// leetcode Studious Student Problem Analysis

import java.util.Arrays;
import java.util.Comparator;

public class minLexOrder {
	public static void main(String args[]) {
		String arr[] = {"abc", "zzz", "cde", "pppp"};
		order od = new order();

		System.out.println(od.lexOrder(arr));
	}

}

class order implements Comparator<String> {
	public int compare(String s1, String s2) {
		if ((s1 + s2).compareTo(s2 + s1) < 0)
			return -1;
		else if ((s2 + s1).compareTo(s1 + s2) < 0)
			return 1;
		else
			return 0;
	}

	public String lexOrder(String arr[]) {
		Arrays.sort(arr);

		String ret = "";
		for (String s : arr)
			ret += s;


		return ret;
	}
}
