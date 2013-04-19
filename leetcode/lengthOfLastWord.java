public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count = 0;
        int i;
        boolean start = true;
        
        for (i = 0; i < s.length(); i++) {
            if (start) {
                if (Character.isLetter(s.charAt(i))) {
                    start = false;
                    count = 1;
                } else {
                    
                }
            } else {
                if (Character.isLetter(s.charAt(i))) {
                    count++;
                } else {
                    start = true;
                }
            }
            
        }
        
        return count;
    }
}
