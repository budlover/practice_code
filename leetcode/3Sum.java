public class Solution {
    HashSet<String> hash;
    ArrayList<ArrayList<Integer>> lists;
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        HashSet<String> hash = new HashSet<String>();
        this.lists = lists;
        this.hash = hash;
        int path[] = new int[3];
        
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) 
            recur(num, i, 0, path, 0);
        
        
        return lists;
    }
    
    private void recur(int[] num, int index, int depth, int path[], int sum) {
        int i;
        
        path[depth] = num[index];
        int tmparr[] = new int[path.length];
        
        if (depth >= 2) {
            if (num[index] + sum == 0) {
                
                String s ="";
                for (int k = 0; k < path.length; k++)
                    s += path[k];
                
                if (!hash.contains(s)) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    for (i = 0; i < path.length; i++)
                        tmparr[i] = path[i];
                        
                    Arrays.sort(tmparr);
                    
                    for (i = 0; i < path.length; i++)
                        list.add(tmparr[i]);
                        
                    lists.add(list);
                    hash.add(s);
                }
            }
            
            return;
        }
        
        for (i = index + 1; i < num.length; i++) 
            recur(num, i, depth + 1, path, sum + num[index]);
            
        return;    
    }
}
