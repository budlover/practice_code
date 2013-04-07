// leetcode Valid Palindrome

import java.lang.StringBuffer;
import java.lang.Character;

public class validPalin {
	public static void main(String args[]) {
		Solution cl = new Solution();
		String s = "1a2";
		System.out.println(cl.isPalindrome(s));
	}

	
}


class Solution {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0)
            return true;
            
        StringBuffer buf = new StringBuffer();
        
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i)))
                buf.append(Character.toLowerCase(s.charAt(i)));
        }
        
		System.out.println(buf);
        int i = 0;
        int j = buf.length() - 1;
        while(i < j) {
            if (buf.charAt(i) != buf.charAt(j))
                return false;
            
            i++;
            j--;
        }
        
        return true;
        
    }
}
