import java.util.ArrayList;

public class maxIncreasingSequence {

	public static void main(String args[]) {
		int arr[] = {1,10,2,10,3,9,10,4,3,2,300,200,100};

		Solution cl = new Solution();
		ArrayList<ArrayList<Integer>> lists = cl.find_wrapper(arr);

		for (ArrayList<Integer> list : lists) {
			for (int i : list) System.out.print(" " + i );

			System.out.println();
		}
	}
}

class Solution {
	ArrayList<ArrayList<Integer>> lists;

	public Solution() {
		lists = new ArrayList<ArrayList<Integer>>();
	}

	public ArrayList<ArrayList<Integer>> find_wrapper(int arr[]) {
		int path[] = new int [arr.length];

		for (int i = 0; i < arr.length; i++) {
			path[0] = arr[i];
			find(arr, i, path, 1);
		}

		return lists;
	}
	
	private void find(int arr[], int index, int path[], int depth) {
		int i;
		boolean flag = false;
		ArrayList<Integer> list;

		for (i = index + 1; i < arr.length; i++) {
			if (arr[i] > arr[index]) {
				flag = true;
				path[depth] = arr[i];
				find(arr, i, path, depth + 1);
			}
		}

		if (flag == false) { // recur to the last level
			if (lists.size() == 0) {
				if (depth > 0) {
					list = new ArrayList<Integer>();
					for (i = 0; i < depth; i++) list.add(path[i]);
					lists.add(list);
				}
			} else {
				if (depth > lists.get(0).size()) {
					lists = new ArrayList<ArrayList<Integer>>();
					list = new ArrayList<Integer>();
					for (i = 0; i < depth; i++) list.add(path[i]);
					lists.add(list);
				} else if (depth == lists.get(0).size()) {
					list = new ArrayList<Integer>();
					for (i = 0; i < depth; i++) list.add(path[i]);
					lists.add(list);
				}
			}

		}

		return;
	}

}
