import java.util.ArrayList;

public class sum3 {
	public static void main(String args[]) {
		Solution cl = new Solution();
		int[] arr = {0,0,0};

		ArrayList<ArrayList<Integer>> lists = cl.threeSum(arr);
		for (ArrayList<Integer> list : lists) {
			for (int i : list)
				System.out.print(" " + i);
			System.out.println();
		}

	}
}

class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        int n = num.length - 1;
        int s, e;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        
        for(i = 0; i < num.length; i++) {
            s = i + 1;
            e = n;
            
            
            while(s < e) {
                int sum2 = num[i] + num[e];
                
				System.out.println("+: " + num[s] + sum2 );

                if (num[s] + sum2 > 0) {
                    e--;
                } else if (num[s] + sum2 < 0) {
                    s++;
                } else {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(num[s]);
                    list.add(num[e]);
                    lists.add(list);        
					s++;
					e--;    
                }
            }
        }
        
        return lists;
    }
}
