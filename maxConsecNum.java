// leetcode Longest Consecutive Sequence

import java.util.*;
import java.lang.Integer;

public class maxConsecNum {
	public static void main(String args[]) {
		int arr[] = {1,0,-1};
		Solution cl = new Solution();

		System.out.println(cl.longestConsecutive(arr));
	}
}

class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : num)
            set.add(i);   
        
        int start, end;
        int count = 0;
        
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int n = it.next();
			int tmp = n;
			set.remove(n);
            start = n;
            end = n;
           
			//System.out.println("n: " + n);
 
            while (set.contains(n + 1)) {
                set.remove(n + 1);
                n++;
                end = end + 1;
            }
            
			n = tmp;
            while (set.contains(n - 1)) {
                set.remove(n - 1);
                n--;
                start = start - 1;
            }
            
            if (end - start + 1 > count)
                count = end - start + 1;
            
			//System.out.println("start: " + start + "end: " + end);    
            it = set.iterator();
        }
        
        
        return count;
    }
}
