import java.lang.Integer;

public class minWindow {
	public static void main(String args[]) {
		String S = "ab";
		String T = "b";

		Solution cl = new Solution();

		System.out.println(cl.minWindow(S,T));

				

	}


}

class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int len = T.length();
        int len2 = S.length();
        int need[] = new int[256];
        int has[] = new int[256];
        int start = 0;
        int end = -1;
        int count = 0;
        int index = 0;
        int min = Integer.MAX_VALUE;
        int i;
        int tmpindex;
        
        if (len2 < len)
            return "";

        for (i = 0; i < len; i++) // stora all needed chars
            need[T.charAt(i)]++;
        
        for (i = 0; i < len2; i++) { // travers all possible end points
            index = S.charAt(i);
            
            if (0 == need[index]) {// nothing will happen
				has[index]++;
                continue;   
			}
            
            if (has[index] < need[index])
                count++;
                
            has[index]++;
            
            if (count >= len) { // satisfay all chars
                tmpindex = S.charAt(start);
                // move forwared the start pointer
                while (has[tmpindex] - 1 >= need[tmpindex]) { // ignore all unnecessary chars
                    if (need[tmpindex] <= 0) { // ignore this char

						System.out.println("jump: start: " + S.charAt(start));

                        start++;
                        tmpindex = S.charAt(start);
                        continue;

                    }
                        
                    has[tmpindex]--;
                    start++;
                    tmpindex = S.charAt(start);
                }
                
                if (i - start + 1 < min) {
                    end = i;
                    min = i - start + 1;
                }
            }
        }
        
        if (count >= len)
            return S.substring(end - min + 1, end + 1);
        else
            return "";
    }
}
