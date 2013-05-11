c class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, j;
        int mul = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int index = k - 1;
        
        for (i = 1; i <= n; i++) list.add(i);
        String ret = "";
        
        for (i = 0; i < n; i++) { // pick number for each digit
            mul = 1;
            for (j = 1; j <= n - (i+1); j++) mul *= j;
            ret += list.get(index / mul);
            list.remove(index / mul);
            
            index %= mul;
        }
        
        return ret;
        
    }
}
