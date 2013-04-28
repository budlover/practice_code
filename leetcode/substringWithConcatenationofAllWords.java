import java.util.HashMap;
import java.util.ArrayList;

public class substringWithConcatenationofAllWords {
	public static void main(String args[]) {
		Solution cl = new Solution();
		String arr[] = {"a","a"};
		String s = "aaa";

		ArrayList<Integer> list = cl.findSubstring(s, arr);
		for (int i : list) System.out.println(i + " ");
	}

}


class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        
        int num = L.length;
        int unit = L[0].length();
        
        ArrayList<Integer> ret = new ArrayList<Integer>();
        HashMap<String, Integer> map;
        
        //for (String s : L) set.add(s);
        
        //go
        int i, j;
        for (i = 0; i <= S.length() - unit * num; i++) {
            map = new HashMap<String, Integer>();
            for (String s : L) {
				if (map.containsKey(s)) map.put(s, map.get(s) + 1);
				else map.put(s, 1);
			}
            
            for (j = 0; j < num; j++) {
                String wd = S.substring(i+j*unit, i+(j+1)*unit);
                
                if(map.containsKey(wd)) {
                    if (map.get(wd) == 1) map.remove(wd);
					else map.put(wd, map.get(wd) - 1);

                    if (map.size() == 0) {
						System.out.println("i: " + i + " j: " + j);

                        ret.add(i);
                        map = new HashMap<String, Integer>();
                        for (String s : L) {
							if (map.containsKey(s)) map.put(s, map.get(s) + 1);
							else map.put(s, 1);
						}
                    }
                } else {
                    break;
                }
            }
        }
        
        return ret;
    }
}
