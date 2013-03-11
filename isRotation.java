public class isRotation {
	public static void main(String args[]) {
		String str1 = "abcde";
		String str2 = "cdeab";

		System.out.println("is Rotation: " + rotation(str1, str2));
	}

	public static boolean rotation(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;

		String s1s1 = str1 + str1;

		if (isSubstring(s1s1, str2))
			return true;
		else
			return false;
	}

	public static boolean isSubstring(String str1, String str2) {
		int l1 = str1.length();
		int l2 = str2.length();

		if (l2 > l1)
			return false;

		for(int i = 0; i <= l1 - l2; i++) {
			if (str1.substring(i, i + l2).equals(str2))
				return true;
		}

		return false;
	}


} 
