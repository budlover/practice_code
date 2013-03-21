public class maxParaSubstring {
    public static void main(String args[]) {
        String str = "abcdzzcba";
        System.out.println("longest para substring: " + para(str));
    }

    public static String para(String str) {
        boolean dp[][] = new boolean[str.length()][str.length()];
        int i, j;
        int len;
        int maxlen = 1;
        int start = 0;

        // for 1 char
        for (i = 0; i < str.length(); i++)
            dp[i][i] = true;
        
        // for 2 adjacent chars
        for (i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                dp[i][i + 1] = true;
                maxlen = 2;
                start = i;
            }
        }

        // for different length
        for (len = 3; len <= str.length(); len++) {
            for (i = 0; i <= str.length() - len; i++) {
                j = i + len - 1;   // end char

                dp[i][j] = dp[i + 1][j - 1] && str.charAt(i) == str.charAt(j);
                if (dp[i][j] && len > maxlen) {
                    maxlen = len;
                    start = i;
                }
            }

        }

        return str.substring(start, start + maxlen);
    }
}
