import java.lang.Character;

public class wordCount {
	public static void main(String args[]) {
		String s = "abc dfe _) #gg #gg z javax";

		System.out.println(count(s));
	}

	private static int count (String str) {
		int i;
		int start = 0;
		String strs[];
		int wcount = 0;

		strs = str.split("\\s", str.length());

		for (String s : strs) {
			for (i = 0; i < s.length(); i++) {
				if (!Character.isLetter(s.charAt(i)))
					break;
			}

			if (i >= s.length())
				wcount++;
		}

		return wcount;
	}
}
