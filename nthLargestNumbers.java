import java.util.ArrayList;

public class nthLargestNumbers {
	public static void main(String args[]) {
		int arr[] = {3,4,5,7,6,8,10,9,2,1};
		int nth = 10;
		ArrayList<Integer> t = getFirstNth(arr, nth);

		System.out.println("first " +  nth + ": " + t);
	}

	public static ArrayList<Integer> getFirstNth (int array[], int nth) {
		if ((0 >= nth) || (0 >= array.length) || (nth > array.length))
			return null;
	
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();

		for (int i = 1; i < array.length; i++) {
			if (array[i] <= array[0])
				list1.add(array[i]);
			else
				list2.add(array[i]);
		}
		list1.add(array[0]);

		if (nth == list1.size()) {
			return list1;
		} else if (nth < list1.size()) {
			int arr[] = new int [list1.size()];
			for (int i = 0; i < list1.size(); i++)
				arr[i] = list1.get(i);
			return getFirstNth(arr, nth);
		} else {
			int arr[] = new int[list2.size()];
			for (int i = 0; i < list2.size(); i++)
				arr[i] = list2.get(i);
			ArrayList<Integer> get = getFirstNth(arr, nth - list1.size());

			// combine two lists
			list1.addAll(get);
			return list1;
		}
	}
	


}
