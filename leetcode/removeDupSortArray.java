c class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int available = -1;
        int i;
        int pre = 0;
        boolean flag = false;
        int count = 0;
        
        for (i = 1; i < A.length; i++) {
            if (A[i] == A[pre])
            {
                if (available == -1) {
                    available = i;
                }
                
                count++;
            } else {
                if (available != -1) {
                    A[available] = A[i];
                    available++;
                }
                
            }
            
            pre = i;
        }
        
        
        return A.length - count;
    }
}
