import java.lang.StringBuffer;
import java.util.ArrayList;

public class permutation {
	public static void main(String args[]) {
		Solution cl = new Solution();


		ArrayList<StringBuffer> list = cl.getPermutation(3);

		for (StringBuffer b : list)
			System.out.println(b.toString());
	}



}

class Solution {
    public ArrayList<StringBuffer> getPermutation(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<StringBuffer> list = new ArrayList<StringBuffer>();
        list.add(new StringBuffer());
        
        for(int i = 1; i <= n; i++) {
            ArrayList<StringBuffer> tmplist = new ArrayList<StringBuffer>();
            
            for (StringBuffer buf : list) {
                ArrayList<StringBuffer> ret = insert(buf, (char)('0' + i));
                tmplist.addAll(ret);
            }
            
            list = tmplist;
        }

		return list;
    }
    
    private ArrayList<StringBuffer> insert(StringBuffer str, char c) {
        ArrayList<StringBuffer> list = new ArrayList<StringBuffer>();
        
        for (int i = 0; i <= str.length(); i++) {
            StringBuffer newstr = new StringBuffer(str.toString());
			newstr.insert(i, c);
            list.add(newstr);
        }
        
        return list; 
    }
}
