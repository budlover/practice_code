import java.lang.Integer;
import java.lang.Character;

public class atoi {
	public static void main(String args[]) {
		String str = "10515182773";
	
		Solution cl = new Solution();
		System.out.println("\n\n" + cl.atoi(str));
	}

}


class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        int flag = 1;
        
        for (i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') continue;
            
            if (str.charAt(i) != '+' && str.charAt(i) != '-' && !Character.isDigit(str.charAt(i)))
                return 0;
            else {
                if (str.charAt(i) == '-') {
                    flag = -1;
                    i++;
                    break;
                } else if (str.charAt(i) == '+') {
                    i++;
                    break;
                } else {
                    break;
                }
            }            
        }
        
        if (i >= str.length() || !Character.isDigit(str.charAt(i)))
            return 0;
        
        int sum = 0;
        int tmp = 0;
        int base = 1;
        
        for(; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                break;
            
            tmp = sum*10 + (str.charAt(i) - '0');
            if (sum > tmp / 10)
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else
                sum = tmp;
        }
        
        return flag == 1 ? sum : (-1)*sum;
    }
}

