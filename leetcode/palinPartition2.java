public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean isPalin[][] = partition(s);
        
        return recur(isPalin, 0, s.length() - 1) - 1;
        
    }
    
    private int recur(boolean isPalin[][], int index, int len) {
        
        int i;
        int minc = Integer.MAX_VALUE;
        
        if (index > len) return 0;

        for (i = index; i <= len; i++) {
            if (isPalin[index][i])
                minc = Math.min(recur(isPalin, i+1, len) + 1, minc);
        }
        
        return minc;
    }
    
    private boolean[][] partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean isPalin[][] = new boolean[s.length()][s.length()];
        int i;
        for (i = 0; i < isPalin.length; i++)  // len = 1
            isPalin[i][i] = true;

        for (i = 0; i < isPalin.length - 1; i++) // len = 2
            if (s.charAt(i) == s.charAt(i + 1))
                isPalin[i][i+1] = true;

        int len, end, j;
        for (len = 3; len <= s.length(); len++) {  // len > 2
            for (i = 0; i <= s.length() - len; i++) {
                j = i + len - 1; // end point
                if (isPalin[i+1][j-1] == true && s.charAt(i) == s.charAt(j))
                    isPalin[i][j] = true;
            }
        }

        return isPalin;
    }

}
