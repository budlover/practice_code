import java.util.Stack;


public class addBinary {
	public static void main(String args[]) {
		Solution cl = new Solution();


		System.out.println(cl.addBinary("111", "101"));


	}


}


class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (a == null || a.length() == 0)
            return b;
        if (b == null || b.length() == 0)
            return a;
            
        Stack<Character> st1 = new Stack<Character>();
        Stack<Character> st2 = new Stack<Character>();
        
        int i;
        for (i = 0; i < a.length(); i++) 
            st1.push(a.charAt(i));
            
        for (i = 0; i < b.length(); i++) 
            st2.push(b.charAt(i));
            
        boolean go = false;
        String ret = "";
        char c, c2;
        
        while (!st1.empty() || !st2.empty()) {
            if (st1.empty()) {
                c = st2.pop();
                if (c == '1') {
                    if (go == true)
                        ret = '0' + ret;
                    else
                        ret = '1' + ret;
                } else {
                    if (go == true) {
                        ret = '1' + ret;
                        go = false;
                    } else {
                        ret = '0' + ret;
                    }
                }
            } else if (st2.empty()) {
                c = st1.pop();
                if (c == '1') {
                    if (go == true)
                        ret = '0' + ret;
                    else
                        ret = '1' + ret;
                } else {
                    if (go == true) {
                        ret = '1' + ret;
                        go = false;
                    } else {
                        ret = '0' + ret;
                    }
                }
            } else { // both are not empty
                c = st1.pop();
                c2 = st2.pop();
                int count = 0;
                if (c == '1')
                    count++;
                if (c2 == '1')
                    count++;
                if (go == true)
                    count++;
                
                if (count == 0) {
                    ret = '0' + ret;
                } else if (count == 1) {
                    ret = '1' + ret;
                    go = false;
                } else if (count == 2) {
                    ret = '0' + ret;
                    go = true;
                } else {
                    ret = '1' + ret;
                    go = true;
                }
            }
        }
        
        if (go != false)
            ret = '1' + ret;
            
        return ret;
    }
}
