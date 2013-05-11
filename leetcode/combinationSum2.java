import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

public class combinationSum2 {
	public static void main(String args[]) {
		Solution cl = new Solution();
		int arr[] = {1};
		int target = 1;
		ArrayList<ArrayList<Integer>> lists = cl.combinationSum2(arr, target);

		for (ArrayList<Integer> list : lists) {
			for (int i : list) System.out.print(i + " ");
			System.out.println();
		}

	}

}

class Solution {
    ArrayList<ArrayList<Integer>> lists;
    HashSet<String> hash;
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        this.lists = new ArrayList<ArrayList<Integer>>();
        this.hash = new HashSet<String>();

        int path[] = new int[target];
        Arrays.sort(candidates);
        
        recur(candidates, 0, path, 0, 0, target);

        return this.lists;
    }

    private void recur(int arr[], int index, int path[], int depth, int sum, int target) {
        if (sum > target) return;

		if (index >= arr.length || depth >= path.length) {
			if (sum != target) return;
		}
        
        int i;
        if (sum == target) {
            String test = "";
            for (i = 0; i < depth; i++) test += path[i];
            if (this.hash.contains(test)) return;
            
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (i = 0; i < depth; i++) list.add(path[i]);

            this.lists.add(list);
            this.hash.add(test);

            return;
        }

        for (i = index; i < arr.length; i++) {
            path[depth] = arr[i];
            recur(arr, i + 1, path, depth + 1, sum + arr[i], target);
        }

        return;
    }
}
