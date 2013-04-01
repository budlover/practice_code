import java.lang.Math;
import java.lang.Character;
import java.lang.String;

public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> list;
        
        if (s.length() > 12 || s.length() < 4)
            return new ArrayList<String>();
            
        list = partition(s, 4);
        
        return list;
    }
    
    private ArrayList<String> partition(String s, int k) {
        if (null == s || s.length() < k || s.length() > 3 * k)
            return null;
        
        ArrayList<String> ret = new ArrayList<String>();
        int i;
        
        for (i = 0; i < Math.min(3, s.length()); i++) {
            String num = s.substring(0, i + 1); // number for this segment
            
            if (i != 0 && num.charAt(0) == '0')
                continue;
                
            if (Integer.parseInt(num) <= 255) {
                if (1 == k) { // the last segment
                    if (i == s.length() - 1) { // add
                        ret.add(num);
                        break;
                    }
                } else { // not the last segment
                    ArrayList<String> remain = partition(s.substring(i + 1), k - 1);
                    if (null != remain) {
                        for (String r : remain) { // if there is nothing in remain, nothing will be added
                            String tmp = num + "." + r;
                            ret.add(tmp);
                        }
                    }
                }
            }  // no need else    
        }
        
        return ret;
    }
}
