import java.util.Stack;

public class largestRectangleInHistogram {
	public static void main(String args[]) {
		int arr[] = {2,1,2};
		Solution cl = new Solution();

		System.out.println(cl.largestRectangleArea(arr));
	}
}


class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i, index;
        int min = Integer.MAX_VALUE;
        int size = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<Integer>();
        
        for (i = 0; i < height.length; i++) {
            if (st.empty() || height[st.peek()] <= height[i]) {

				System.out.println("if i= " + i);
                st.push(i);
            } else { // finalize it
                int tar_index = st.peek();
                min = Integer.MAX_VALUE;
                
                while (!st.empty() && height[st.peek()] > height[i]) { // keep pop
                    index = st.pop();

					System.out.println("else i=" + i);

                    if (height[index] < min) min = height[index];
                    if (min * (tar_index-index+1) > size) size = min * (tar_index-index+1); 
                }

				st.push(i);
				
				System.out.println("here1 " + size);                
            }
        }
        
        if (!st.empty()) {
            int tar_index = st.peek();
            min = Integer.MAX_VALUE;
            
            while (!st.empty()) { // keep pop
                index = st.pop();
                if (height[index] < min) min = height[index];
                if (min * (tar_index-index+1) > size) size = min * (tar_index-index+1); 
            }

			System.out.println("here2 " + size);
        }
        
        return size;
    }
}
