public class jumpGame {
	public static void main(String args[]) {
		int arr[] = {2,0,0};

		Solution cl = new Solution();

		System.out.println(cl.canJump(arr));
	}

}

class Solution {
    public boolean canJump(int[] A) {
        int i;
        
        int marker = A.length - 1;
        int end;
        
        if (A.length == 1)
            return true;
            
        if (A.length == 2) {
            if (A[0] >=1)
                return true;
            else
                return false;
        }
        
        for (end = A.length - 2; end >= 0; end--) {
            
            if (end == 0) {
				System.out.println("end: " + end + " A[end]: " + A[end] + " marker: " + marker);

			}



            if (A[end] >= marker - end) {
                marker = end;
                if (marker == 0)
                    return true;
            }
            
        }
        
        return false;
        
    }
}
