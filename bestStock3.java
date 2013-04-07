import java.util.HashSet;
import java.util.Iterator;
import java.lang.Integer;
import java.lang.Math;
import java.util.Arrays;

public class bestStock3 {
	public static void main(String args[]) {
		int arr[] = {3,3,5,0,0,3,1,4};
		
		System.out.println(maxProfit(arr));
	}

	private static int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int i;
        int min = Integer.MAX_VALUE / 2;
        int maxUntilThis[] = new int[prices.length];
        int maxFromThis[] = new int[prices.length];
        int max = Integer.MIN_VALUE / 2;
        int total = 0;
        int hist = 0;
;
        // forward
        for (i = 0; i < prices.length; i++) {
            if (prices[i] < min)
                min = prices[i];
            
            hist = Math.max(hist, prices[i] - min);
			maxUntilThis[i] = hist;
        }
        
        //backward
		hist = 0;
        for (i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > max)
                max = prices[i];
            
            hist = Math.max(hist, max - prices[i]);
            maxFromThis[i] = hist;
			
			if (i == prices.length - 1)
				System.out.println("price: " + prices[i] + " max: " + max + " hist: " + hist);

            total = Math.max(total, maxFromThis[i] + maxUntilThis[i]);
        }
        
		System.out.println("from: " + Arrays.toString(maxFromThis));
		System.out.println("until: " + Arrays.toString(maxUntilThis));

        return total;
    }
}
