public class stringCompress {
	public static void main(String[] args) {
		String str = "aaaaaaaabbbaaaabbbcc";
		
		System.out.println("Copress: " + compress(str));

		return;
	}

	public static String compress(String str) {
		if (!shorter(str))	
			return str;

		String ret = "";
		char tmp = str.charAt(0);
		int count = 1;

		for (int i = 1; i < str.length(); i++) {
			if (tmp != str.charAt(i)) {
				ret += tmp;
				ret += count;
				tmp = str.charAt(i);
				count = 1;
			} else {
				count++;
			}
		}

		// add the last characters
		ret += tmp;
		ret += count;

		return ret;
	}

	private static boolean shorter(String str) {
		if (str.length() <= 1)
			return false;

		char tmp = str.charAt(0);
		int newlen = 2;

		for (int i = 1; i < str.length(); i++) {
			if (tmp != str.charAt(i)) {
				tmp = str.charAt(i);
				newlen += 2;
			}
		}

		//System.out.println("newlen: " + newlen);
		if (newlen < str.length())
			return true;
		else
			return false;
	}
}
