import java.util.HashMap;

public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //HashMap<Integer, Integer[]> = new HashMap<Integer, Integer[]>();
        ArrayList<String> list = new ArrayList<String>();
        
        if (digits.length() == 0) {
            list.add("");
            return list;
        }
        
        int index;
        char c;
        char arr[][] = 
        {{'a','b','c'}, {'d','e','f'}, {'g','h','i'},
        {'j','k','l'}, {'m','n','o'}, {'p','q','r', 's'}, 
        {'t','u','v'}, {'w','x','y', 'z'}};
        
        int i;
        for (i = 0; i < digits.length(); i++) {
            c = digits.charAt(i);
            index = c - '2';
            
            ArrayList<String> tmplist = new ArrayList<String>();
            for(char x : arr[index]) {
                if (list.size() == 0) {
                    tmplist.add("" + x);
                    
                } else {
                    for (String str : list) {
                        String newstr = new String(str);
                        newstr += x;
                        tmplist.add(newstr);
                    }
                }
            }
            
            
            
            list = tmplist;
        }
        
        return list;
    }
}
