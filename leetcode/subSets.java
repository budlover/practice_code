public class Solution {
    ArrayList<ArrayList<Integer>> lists;
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        lists.add(new ArrayList<Integer>());
        
        if (S == null || S.length == 0)
            return lists;
            
        int arr[] = S.clone();
        Arrays.sort(arr);
        this.lists = lists;
        
        
        int i;
        for (i = 0; i < arr.length; i ++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            
            recur(arr, i, list);
        }
        
        return this.lists;
    }
    
    private void recur(int arr[], int index, ArrayList<Integer> list) {
        int i;
        
        if (index >= arr.length)
            return;
        
        ArrayList<Integer> cp = new ArrayList<Integer>();
        cp.addAll(list);
        cp.add(arr[index]);
        this.lists.add(cp);
        
        for (i = index + 1; i < arr.length; i++) {
            recur(arr, i, cp);
        }
        
        return;
    }
}
