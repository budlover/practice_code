import java.util.Arrays;

public class removeDuplicatesFromSortedArray2 {
	public static void main(String args[]) {
		Solution cl = new Solution();
		int arr[] = {1,1,1,2};

		int ret = cl.removeDuplicates(arr);

		for (int i = 0; i < ret; i++) System.out.print(" " + arr[i]);
		System.out.println();
	}

}

class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution belo[w
        // DO NOT write main() function
        boolean flag[] = new boolean[A.length];
        int i;
        int pos = 0;
        
        if (A.length <= 2) return A.length;
        
        for(i = 2; i < A.length; i++) {
            if (A[i] == A[i-2]) flag[i] = true;
        }
        
		i = 0;
        while (i < A.length) {
            if(flag[i] == true) {
                if (pos == 0) {
                    pos = i;
                } else {
                    while(flag[i] == true) {
						i++;
						if (i >= A.length) break;
					}
                    
					if (i >= A.length) break;

                    A[pos] = A[i];
                    pos++;
                }
            } else {
				if (pos != 0) {
					A[pos] = A[i];
					pos++;
				}
			}
            
            i++;

			System.out.println("pos= " + pos);
        }
        
        if (pos == 0) return A.length;
        
		//System.out.println(Arrays.toString(flag));
        return pos;
    }
}
