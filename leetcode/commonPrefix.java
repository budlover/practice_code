import java.lang.StringBuilder;

public class commonPrefix {
	public static void main(String args[]) {
		String arr[] = {"a","b"};

		Solution cl = new Solution();

		System.out.println(cl.longestCommonPrefix(arr));
	}

	
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function   
        if (strs.length == 0) return "";
        
        StringBuilder sb = new StringBuilder(strs[0]);
        
        int i, j;
        int len;
        boolean flag;
        
        for (i = 1; i < strs.length; i++) {
            flag = false;
            
            len = sb.length() < strs[i].length() ? sb.length() : strs[i].length();
            if (len == 0) return "";
            
            for (j = 0; j < len; j++) {
                if (sb.charAt(j) != strs[i].charAt(j)) {
					System.out.println("len: " + len);
                    flag = true;
                    break;
                }
            }
            
            if (true == flag || j <= sb.length() - 1) {
                sb.delete(j, sb.length());
				System.out.println("delete j: " + j + " " + sb.toString());
                if (sb.length() <= 0)
                    return "";
            }
        }
        
        return sb.toString();
    }
}
