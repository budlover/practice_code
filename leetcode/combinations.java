public class Solution {
    ArrayList<ArrayList<Integer>> lists;
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        this.lists = lists;
        
        if (k > n)
            return this.lists;
            
        int record[] = new int[k + 1];
        for (int index = 1; index <= n - k + 1; index++)
            recur(n, k, index, record, 1);
        
        return this.lists;
    }
    
    private void recur(int n, int k, int index, int record[], int depth) {
        if (index >= n && depth < k) // no way
            return;
        
        if (depth == k) { // last step
            record[depth] = index;
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 1; i < record.length; i++)
                list.add(record[i]);
            this.lists.add(list);
            return;
        }
        
        record[depth] = index;
        
        for (int i = index + 1; i <= n; i++)
            recur(n, k, i, record, depth + 1);
            
        return;
    }
    
}
