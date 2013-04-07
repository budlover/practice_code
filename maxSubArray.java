import java.lang.Integer;

public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (null == A || A.length == 0)
            return 0;
        
        int sum = -1;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < A.length; i++) {
            sum = sum >= 0 ? sum + A[i] : A[i];
            max = sum > max ? sum : max;
        }
        
        return max;
    }
}
