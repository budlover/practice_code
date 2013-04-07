import java.lang.StringBuffer;

public class symmetryPoint {
	public static void main(String args[]) {
		Solution s = new Solution();

		System.out.println(s.symmetryPoint("abcdcba"));
	}

}

class Solution { 
	public int symmetryPoint(String S) {
		int len = S.length();
		if (0 > len || len % 2 == 0) 
			return -1;

		if (1 == len)
			return 0;

		String l = S.substring(0, len / 2);
		String r = S.substring(len / 2 + 1, len);
		StringBuffer buf = new StringBuffer(r);

		if (!buf.reverse().toString().equals(l))
			return -1;

		return len / 2;
	}

}
