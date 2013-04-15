import java.util.Arrays;

public class nextPermutation {
	public static void main(String args[]) {
		int arr[] = {1,3,2};
		Solution cl = new Solution();

		cl.nextPermutation(arr);

		System.out.println(Arrays.toString(arr));
	}


}


class Solution {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        int j = 0;
        boolean flag = false;

        if (num.length == 0 || num.length == 1)
            return;
            
        for (i = num.length - 1; i >= 0; i--) {
            for(j = num.length - 1; j > i; j--) {
                if (num[i] < num[j]) {
					flag = true;
                    break;
				}
            }

			if (true == flag)
				break;
        }

		System.out.println("pre: " + i + " post: " + j);

       
        if (i < 0) {// asending order
            reverse(num, 0, num.length - 1);
            return;
        }
        
        
        // swp i & j
        int tmp = num[j];
        num[j] = num[i];
        num[i] = tmp;


		System.out.println("before swp: " + Arrays.toString(num));
        
        reverse(num, i+1, num.length - 1);
    }
    
    private void reverse(int num[], int x, int y) {
        int limit = x + (y - x) / 2;
        int tmp;
        
		System.out.println("swap  pre: " + x + " post: " + y);

        if (x >= y)
            return;
            
        for (int i = x; i <= limit; i++) {
            tmp = num[i];
            num[i] = num[x + y - i];
            num[x + y - i] = tmp;
        }
        
        return;
    }
}
