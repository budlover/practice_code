import java.util.HashSet;
import java.util.Iterator;
import java.lang.Integer;

public class bestStock {
	public static void main(String args[]) {
		int arr[] = {1, 2};
		
		System.out.println(maxProfit(arr));
	}

	private static int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (null == prices)
            return -1;
        
        if (prices.length == 0 || prices.length == 1)
            return 0;
        
        HashSet<Integer> starts = new HashSet<Integer>();
        int i;
        int min = Integer.MAX_VALUE;

        for (i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                starts.add(i);
                min = prices[i];
            }
        }
    
        int maxval = -1;
        Iterator<Integer> itr = starts.iterator();
        while(itr.hasNext()) {
            int index = itr.next();
            for (i = index; i < prices.length; i++) {
                if (starts.contains(i) || prices[i] < prices[index])
                    continue;
                    
				System.out.println("start: " + index + " end " + i);

                if (prices[i] - prices[index] > maxval)
                    maxval = prices[i] - prices[index];
            }
        }
        
        maxval = maxval < 0 ? 0 : maxval;
    
        return maxval;
    }
}
