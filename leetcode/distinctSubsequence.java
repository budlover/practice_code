public class distinctSubsequence {
	public static void main(String args[]) {
		Solution cl = new Solution();

		System.out.println(cl.numDistinct("aaa","a"));
	}

}

class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int dp[][] = new int[T.length()][S.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;
        }
        
        
        return recur(S, S.length() - 1, T, T.length() - 1, dp);
    }
    
    private int recur(String S, int is, String T, int it, int dp[][]) {
        if (it < 0) return 1;
        if (is < 0) {
            if (it < 0) return 1;
            else return 0;
        }
        
        int ret1, ret2;
        
        if (dp[it][is] != -1) return dp[it][is];
        
        if (S.charAt(is) != T.charAt(it)) {
            ret1 = recur(S, is - 1, T, it, dp);
            dp[it][is] = ret1;
            
            return ret1;
        } else {
             ret1 = recur(S, is - 1, T, it - 1, dp);
             ret2 = recur(S, is - 1, T, it, dp);
             dp[it][is] = ret1 + ret2;
             
             return ret1 + ret2;
        }
    }
}
