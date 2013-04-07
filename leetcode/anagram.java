import java.util.HashMap;
import java.util.Arrays;
import java.util.Iterator;

public class Solution {
    
    
    public ArrayList<String> anagrams(String[] strs) {
        
        HashMap<String, ArrayList<String>> hash = new HashMap<String, ArrayList<String>>();
        
        
        for (String str : strs) {
            char carr[] = str.toCharArray();
            Arrays.sort(carr);
            String newstr = new String(carr); 
            
            if (hash.containsKey(newstr)) {
                hash.get(newstr).add(str);
            } else {
                ArrayList<String> newlist = new ArrayList<String>();
                newlist.add(str);
                hash.put(newstr, newlist);
            }
        }
    
        ArrayList<String> ret = new ArrayList<String>();
        
        Iterator it = hash.values().iterator();
        while(it.hasNext()) {
            ArrayList<String> l = (ArrayList<String>)it.next();
            if (l.size() > 1)
                ret.addAll(l);
        }
        
        return ret;
    }
}
