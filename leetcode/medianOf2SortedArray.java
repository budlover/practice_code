import java.util.Stack;

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Integer> st = new Stack<Integer>();
        
        int pa = 0;
        int pb = 0;
        
        int lena = A.length;
        int lenb = B.length;
        int target = (lena + lenb) / 2 + 1;
        int len = 0;
        
        if (lena + lenb == 0)
            return 0;
            
        
        while(pa < lena || pb < lenb) {
            if (len >= target)
                break;
                
            if (pa >= lena) {
                st.push(B[pb]);
                pb++;
            } else if (pb >=lenb) {
                st.push(A[pa]);
                pa++;
            } else {
                if (A[pa] <= B[pb]) {
                    st.push(A[pa]);
                    pa++;
                } else {
                    st.push(B[pb]);
                    pb++;
                }
                
            }
            
            len++;
        }
        
        //if (lena + lenb == 1)
            //return ((float)st.pop());
            
        if ((lena + lenb) % 2 == 0) {
            double x = st.pop();
            double y = st.pop();
            return (x + y) / 2.0; 
        } else {
            return st.pop();
        }
    }
}
