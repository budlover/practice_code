import java.util.ArrayList;
import java.util.Arrays;

public class longestCommonSubstring {
	public static void main(String args[]) {
		String str1 = "yyyyyabcdefghyyyyy";
		String str2 = "zzzzzzghzzzzzz";

		System.out.println(commomString(str1, str2));
	}
	
	public static String commomString(String str1, String str2) {
		int arr[][] = new int[str1.length()][str2.length()]; // init all 0
		int maxLen = 0;
		int startPoint = -1;
		String common = "";

		for (int i = 0; i < str1.length(); i++) {
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i) != str2.charAt(j)) // nothing will happen here
					continue;

				if (0 == i || 0 == j)
					arr[i][j] = 1;
				else
					arr[i][j] = arr[i - 1][j - 1] + 1;

				if (arr[i][j] > maxLen) {
					maxLen = arr[i][j];
					
					if (startPoint != j - maxLen + 1) { // need reset start point
						startPoint = j - maxLen + 1;
						common = str2.substring(startPoint, j + 1);
					} else { // not reset start point
						common += str2.charAt(j);
					}
				}
			}
		}

		return common;
	}
}
