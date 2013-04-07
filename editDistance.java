import java.lang.Math;

public class editDistance {
	public static void main(String args[]) {
		String s1 = "a";
		String s2 = "b";

		Solution cl = new Solution();
		System.out.println(cl.minDistance(s1, s2));

	}

}



class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (word1.length() == 0)
            return word2.length();
        
        if (word2.length() == 0)
            return word1.length();

        int [][] dp = new int[word1.length() + 1][word2.length() + 1];
        int i, j;
        int len1 = word1.length();
        int len2 = word2.length();
        
        // first row
        for (i = 0; i < len2 + 1; i++) 
            dp[0][i] = i;
    
        // first col
        for (i = 0; i < len1 + 1; i++) 
            dp[i][0] = i;
        
        for (i = 1; i < len1 + 1; i++) {
            for (j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) { // same char
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                
                // dirfferent chars
                int min = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                min = Math.min(min, dp[i - 1][j - 1] + 1);
                
                dp[i][j] = min;
            }
        }
        
        return dp[len1][len2];
    }
}
