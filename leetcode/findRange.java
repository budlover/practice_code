import java.util.Arrays;

public class findRange {
	public static void main(String args[]) {
		int arr[] = {0,0,1,2,2};
		int target = 2;		

		Solution cl = new Solution();

		System.out.println(Arrays.toString(cl.searchRange(arr, target)));
	}

}

class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = 0;
        int r = A.length - 1;
        int mid = 0;
        int ret[] = new int[2];
        
        ret[0] = -1;
        ret[1] = -1;
        
        if (A.length == 0)
            return ret;
        
        while (l <= r) {
            mid = l + (r - l) / 2;
            
            if (A[mid] == target)
                break;
            else if (A[mid] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        
        if (l > r) 
            return ret;
    
       
		System.out.println("mid: " + mid);


 
        int i;
        
        for (i = mid + 1; i < A.length; i++) {
            if (A[i] != target)
                break;
        }
        
        ret[1] = i - 1;
        
        for (i = mid - 1; i >= 0; i--) {
            if (A[i] != target)
                break;
        }
        
        ret[0] = i + 1;
        
        return ret;
    }
}
