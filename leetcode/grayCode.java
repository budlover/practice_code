public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j;
        HashSet<Integer> hash = new HashSet<Integer>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        
        if (n == 0) return ret;
        
        int num = 0;
        hash.add(num);
        
        
        for (i = 0; i < (1<<n) -1; i++) { // 2^n numbers
            for (j = 0; j < n; j++) {
                int tmp = num;
                if (!hash.contains(num ^ (1<<j))) break;
            }
            
            num = num ^ (1<<j);
            hash.add(num);
            ret.add(num);
        }
        
        return ret;
    }
}
