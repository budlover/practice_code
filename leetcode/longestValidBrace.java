import java.util.Stack;

public class longestValidBrace {
	public static void main(String args[]) {
		String s = "(()";		

		Solution cl = new Solution();

		System.out.println(cl.longestValidParentheses(s));
	}

	

}



class Solution {
    class Pair {
        public char brace;    
        public int index;
        public Pair(char x, int y) {brace = x; index = y;}
    }
    
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] arr = s.toCharArray();
        int i;
        int maxlen = 0;
        int pos = 0;
        Stack<Pair> st = new Stack<Pair>();
        
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                st.push(new Pair(arr[i], i));
            } else {
                if (!st.empty()) {
                    Pair p = st.pop();
                    if (st.empty())
                        maxlen = Math.max(maxlen, i - pos + 1);
                    else
                        maxlen = Math.max(maxlen, i - st.peek().index);
                } else {
                    pos = i + 1;
                }
            }
        }
        
        return maxlen;
    }
}

