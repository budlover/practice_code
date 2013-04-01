import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Iterator;

public class subSets2 {
	public static void main(String args[]) {
		return;
	}

}

class Solution {
    HashSet<ArrayList<Integer>> hash;
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<ArrayList<Integer>> hash = new HashSet<ArrayList<Integer>>();
        hash.add(new ArrayList<Integer>());
        if (null == num || num.length == 0)
            return new ArrayList<ArrayList<Integer>>();
            
        int arr[] = num.clone();
        Arrays.sort(arr);
        
        this.hash = hash;
        
        int i;
        for (i = 0; i < arr.length; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            recur(arr, i, list);
        }
        
        ArrayList<ArrayList<Integer>> arrlists = new ArrayList<ArrayList<Integer>>();
        
        Iterator<ArrayList<Integer>> itr = hash.iterator();
        while (itr.hasNext())
            arrlists.add(itr.next());
            
        return arrlists;
    }
    
    private void recur(int arr[], int index, ArrayList<Integer> list) {
        
        if (index >= arr.length)
            return;
            
        ArrayList<Integer> cplist = new ArrayList<Integer>();
        cplist.addAll(list);
        cplist.add(arr[index]);
        
        this.hash.add(cplist);
        
        int i;
        for (i = index + 1; i < arr.length; i++)
            recur(arr, i, cplist);
        
        
        return;
    }
}
