public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
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
        
        ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
        ArrayList<String> path = new ArrayList<String>();
        
        recur(s, isPalin, 0, path, lists);
        
        return lists;
    }
    
    private void recur(String s, boolean isPalin[][], int index, ArrayList<String> path, ArrayList<ArrayList<String>> lists) {
        if (index >= s.length()) {
            ArrayList<String> list = new ArrayList<String>();
            for (String tmpstr : path)
                list.add(tmpstr);
            
            lists.add(list);
            
            return;
        }
        
        int i;
        for (i = index; i < s.length(); i++) {
            if (isPalin[index][i] == true) {
                ArrayList<String> newpath = new ArrayList<String>();
                for (String tmpstr : path)
                    newpath.add(tmpstr);
                
                newpath.add(s.substring(index, i+1));
                
                recur(s, isPalin, i + 1, newpath, lists);
            }
        }
        
        return;
    }
}
