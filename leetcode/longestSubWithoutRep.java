public class longestSubWithoutRep {
	public static void main(String args[]) {
		String s = "abcabcbb";
		Solution cl = new Solution();

		System.out.println(cl.lengthOfLongestSubstring(s));
	}

} 


class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        int j = 0;
		int max = 0;
        //HashSet<Character> hash = new HashSet<Character>();
        boolean arr[] = new boolean[26];

		while(j < s.length()) {
			if (arr[s.charAt(j) - 'a'] != true) {
				arr[s.charAt(j) - 'a'] = true;
				max = j - i + 1 > max ? j - i + 1 : max;

				j++;
			} else { // repeat

				while(s.charAt(i) != s.charAt(j)) {
					arr[s.charAt(i) - 'a'] = false;
					i++;
				}

				arr[s.charAt(i) - 'a'] = false;
				i++;

				//System.out.println("i: " + i + " char i:  " + s.charAt(i) + " j: " + j + " charj: " + s.charAt(j));
			}

		}

		return max;
    }
}
