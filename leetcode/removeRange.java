public class removeRange {
	public static void main(String args[]) {
		int arr[] = {4,5};
		
		Solution cl = new Solution();
		int ret = cl.removeElement(arr, 4);
		for (int i = 0; i < ret; i++)
			System.out.print(" " + arr[i]);
	}

}

class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length == 0)
            return 0;
        
        boolean arr[] = new boolean[A.length];
        int i;
        for (i = 0; i < A.length; i++) {
            if (elem == A[i])
                arr[i] = true;
        }
        
        int pos = 0;
        for (i = 0; i < A.length; i++) {
            if (arr[i] == true) {
                pos = i;
                break;
            }
        }

		System.out.println("insert pos: " + i);

        
        if (i >= A.length)
            return A.length;
        
        int j;
        for (j = i+1; j < A.length; j++) {
            if (arr[j] == false) {
				System.out.println("arr[i] " + arr[i] + " arr[j]: " + arr[j]);
                A[i] = A[j];
                i++;
            }
        }

		System.out.println("insert pos: " + i);

        
        return i;
    }
}
