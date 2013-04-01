public class interleavingString {
	public static void main(String args[]) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbcbbcac";
	
		Solution cl = new Solution();

		System.out.println(cl.isInterleave(s1,s2,s3));

	}
}

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1.length() == 0) {
            if (s2.equals(s3))
                return true;
            else
                return false;
        }
        
        if(s2.length() == 0) {
            if (s1.equals(s3))
                return true;
            else
                return false;
        }
        
        if (s1.length() + s2.length() != s3.length())
            return false;
            
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int k = s3.length() - 1;
        while (i >= 0 || j >=0) {
            if (i >= 0 && s1.charAt(i) == s3.charAt(k)) {
				if (i == 0 && j > i && s1.charAt(i) == s2.charAt(j)) {
					j--;
					k--;
					continue;
				}

                i--;
                k--;
            } else if (j >= 0 && s2.charAt(j) == s3.charAt(k)) {
                j--;
                k--;
            } else {
				System.out.println("i: "+i+" j: "+j+" k: " + k );
                return false;
            }
        }
        
        return true;
    }
}
