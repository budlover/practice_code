import java.util.ArrayList;

public class allSubsets {
	public static void main(String args[]) {
		int arr[] = {0};

		Solution cl = new Solution();


		cl.subsets(arr);


	}


}

class Solution {
    ArrayList<ArrayList<Integer>> listswa;
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        lists.add(new ArrayList<Integer>()); // add an empty set
        
        if (S == null || S.length == 0)
            return lists;
        
        this.listswa = lists;
        recur(S, 0);
        
        return this.listswa;
    }
    
    private void recur(int[] arr, int index) {
        if (index >= arr.length)
            return;
            
        ArrayList<ArrayList<Integer>> tmplists = new ArrayList<ArrayList<Integer>>(this.listswa);
        for(ArrayList<Integer> l : tmplists) {
            ArrayList<Integer> tmplist = new ArrayList<Integer>();
			tmplist.addAll(l);
            tmplist.add(arr[index]);
            this.listswa.add(tmplist);
        }
        
        recur(arr, index + 1);
        
        return;
    }
}
