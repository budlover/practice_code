import java.util.Arrays;

public class Solution {
    ArrayList<ArrayList<Integer>> lists;
    
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        this.lists = lists;
        
        int path[] = new int[target];
        Arrays.sort(candidates);
        
        int i;
        
        for (i = 0; i < candidates.length; i++) {
            recur(candidates, i, path, 0, 0, target);
        }
        
        return this.lists;
    }
    
    private void recur(int arr[], int index, int path[], int depth, int sum, int target) {
        if (sum + arr[index] > target || depth >= path.length)
            return;
        
        int i;
        
        if (sum + arr[index] == target) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (i = 0; i < depth; i++)
                list.add(path[i]);
                
            list.add(arr[index]);
            this.lists.add(list);
            
            return;
        }
        
        path[depth] = arr[index];
        for (i = index; i < arr.length; i++)
            recur(arr, i, path, depth + 1, sum + arr[index], target);
            
        return;
    }
}
