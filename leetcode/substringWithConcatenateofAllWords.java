import java.util.HashMap;

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> range = new ArrayList<Integer>();
        if (L.length == 0) 
            return range;
            
        //HashSet<String> hash = new HashSet<String>();
        
        //for (String wd : L)
        //    addmap()
        
        // sliding window
        int len = L[0].length() * L.length;
        if (S.length() < len) 
            return range;
    
        
        int i, j;
        //int count = 0;
        for (i = 0; i < S.length() - len + 1; i++) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (String wd : L)
                addmap(map, wd);
                
            //count = 0;
            for (j = 0; j < L.length; j++) {
                String word = S.substring(i + j*L[0].length(), i + (j+1)*L[0].length());
                if (!checkmap(map, word))
                    break;
            }
            
            
            if (j >= L.length) 
                range.add(i);      
        }
        
        return range;
    }
    
    private void addmap(HashMap<String, Integer> map, String str) {
        if (map.containsKey(str))
            map.put(str, map.get(str) + 1);
        else
            map.put(str, 1);
        
        return;
    }
    
    private boolean checkmap(HashMap<String, Integer> map, String str) {
        if (!map.containsKey(str))
            return false;
        
        if (map.get(str) <= 0)
            return false;
        
        map.put(str, map.get(str) - 1);
        
        if (map.get(str) == 0)
            map.remove(str);
            
        return true;   
    }
}
