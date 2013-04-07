c class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = 0;
        int r = A.length - 1;
        int m;
        
        if (A == null || A.length == 0)
            return false;
            
        while (l <= r) {
            m = l + (r - l) / 2;
            if (A[m] == target)
                return true;
            
            if (A[l] < A[m]) { // left sub ordered
                if (A[l] <= target && target < A[m]) { // serch in left
                    r = m - 1;
                } else
                    l = m + 1;
            } else if (A[l] > A[m]) {
                if (target <= A[r] && A[m] < target) { // serch in left
                    l = m + 1;
                } else
                    r = m - 1;
            } else {
                l++;
            }
        }
        
        return false;
    }
}
