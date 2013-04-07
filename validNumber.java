import java.lang.Character;

public class validNumber {
	public static void main(String args[]) {
		String s = "   0.1   ";

		Solution cl = new Solution();

		System.out.println(cl.isNumber(s));
	}


}


class Solution {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int i;
        
        if (s == null || s.length() == 0)
            return false;
        
        for (i = 0; i < s.length(); i++){
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ')
                break;
        }
        
        if (i == s.length())
            return true;
        
        int j;
        // '.' case
        if (s.charAt(i) == '.') {
            for(j = i + 1; j < s.length(); j++) {
                if (!Character.isDigit(s.charAt(j)))
                    break;
            }
            
            if (j != s.length()) {
                if (s.charAt(j) != ' ' || j == i + 1) {
					System.out.println("err1");
                    return false;                    
				}
            }
            
            for(j = i - 1; j >= 0; j--) {
                if (!Character.isDigit(s.charAt(j)))
                    break;
            }
            
            if (j >= 0) {
                if (s.charAt(j) != ' ' || j == i - 1) {
					System.out.println("err2");
                    return false;                    
				}
            }
        } else if (s.charAt(i) == 'e') {
            for(j = i; j < s.length(); j++) {
                if (!Character.isDigit(s.charAt(j)))
                    return false;
            }
            
            for(j = i; j >= 0; j--) {
                if (!Character.isDigit(s.charAt(j)))
                    return false;
            }
        } else {
            return false;
        }
        
        return true;
    }
}
