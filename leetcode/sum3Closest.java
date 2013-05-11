import java.lang.Math;
import java.lang.Integer;
import java.util.Arrays;

public class sum3Closest {
	public static void main(String args[]) {
		int arr[] = {1,1,-1};
		Solution cl = new Solution();

		System.out.println(cl.threeSumClosest(arr, 2));

	}


}

class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i;
        int s, e;
        int n = num.length - 1;
        int close = Integer.MAX_VALUE;
        int rec = 0;
                    
		Arrays.sort(num);

        for (i = 0; i <=n; i++) {
            s = i + 1;
            e = n;
            int sum2 = 0;

            
            while (s < e) {
                sum2 = num[i] + num[e];
                
                if (sum2 + num[s] > target) {
                    if (Math.abs(sum2 + num[s] - target) < close) {
                        close = Math.abs(sum2 + num[s] - target);
                        rec = sum2 + num[s];
                    }
					e--;
                } else if (sum2 + num[s] < target) {
                    
                    if (Math.abs(sum2 + num[s] - target) < close) {
                        close = Math.abs(sum2 + num[s] - target);
                        rec = sum2 + num[s];
                    }
					s++;
                } else {
                    return target;
                }
            }
        }
        
        return rec;
    }
}
