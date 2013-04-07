// multiply 2 numbers represented by string

import java.lang.Character;
import java.util.LinkedList;
import java.lang.StringBuffer;

public class stringMultiply {
	public static void main(String args[]) {
		String s1 = "-30";
		String s2 = "0";

		System.out.println("ret: " + multi(s1, s2));
	}

	private static String multi(String s1, String s2) {
		int sign = 1;
		int i, j;

		LinkedList<LinkedList<Integer>> lists = new LinkedList<LinkedList<Integer>>();

		if (s1 == null || s2 == null || 0 == s1.compareTo("-") || 0 == s2.compareTo("-")) {
			System.out.println("s1 not a number.");
			return null;
		}

		for (i = 0; i < s1.length(); i++) {
			if (i == 0 && s1.charAt(i) == '-') 
				continue;

			if (!Character.isDigit(s1.charAt(i))) {
				System.out.println("s1 not a number.");
				return null;
			}
		}		

		for (i = 0; i < s2.length(); i++) {
			if (i == 0 && s1.charAt(i) == '-') 
                continue;

			if (!Character.isDigit(s2.charAt(i))) {
				System.out.println("s2 not a number.");
				return null;
			}
		}
		
		if (s1.charAt(0) == '-' && s2.charAt(0) == '-') {
			s1 = s1.substring(1, s1.length());
			s2 = s2.substring(1, s2.length());
		} else if (s1.charAt(0) == '-' && s2.charAt(0) != '-') {
			s1 = s1.substring(1, s1.length());
			sign = -1;
		} else if (s1.charAt(0) != '-' && s2.charAt(0) == '-') {
			s2 = s2.substring(1, s2.length());
			sign = -1;
		}

		String str1, str2;
		if (s1.length() > s2.length()) {
			str1 = s1;
			str2 = s2;
		} else {
			str2 = s1;
			str1 = s2;
		}

		int thispos = 0;
		int nextpos = 0;
		int tmp;
		int maxlen = 0;

		for(i = s2.length() - 1; i >= 0; i--) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			int len = 0;
			for (j = s1.length() - 1; j >=0; j--) {
				int m1 = (int)(s1.charAt(j) - 48);
				int m2 = (int)(s2.charAt(i) - 48);
				
				thispos = m1 * m2 % 10 + nextpos;
				nextpos = m1 * m2 / 10;

				if (thispos >= 10) {
					thispos = thispos % 10;
					nextpos++;
				}

				list.addLast(thispos);
				len++;

				if (0 == j && nextpos > 0) {
					list.addLast(nextpos);
					len++;
				}

				maxlen = len > maxlen ? len : maxlen;
			}

			lists.addLast(list);
		}

		int addzero = 0;
		maxlen += lists.size() - 1;
		LinkedList<Integer> sumlist = new LinkedList<Integer>();
		for(i = 0; i < maxlen; i++)
			sumlist.addLast(0);
		//System.out.println("maxlen: " + maxlen);



		for (LinkedList<Integer> list : lists) {
			for (i = 0; i < addzero; i++)
				list.addFirst(0);

			for (i = 0; i < list.size(); i++)
				sumlist.set(i, sumlist.get(i) + list.get(i));
		
			System.out.println();
			addzero++;
		}

		nextpos = 0;
		StringBuffer ret = new StringBuffer();

		for(i = 0; i < sumlist.size(); i ++) {
			thispos = sumlist.get(i) % 10 + nextpos;
            nextpos = sumlist.get(i) / 10;

            if (thispos >= 10) {
                thispos = thispos % 10;
                nextpos++;
            }

			ret.append(thispos);
			if (i == sumlist.size() - 1 && nextpos > 0)
				ret.append(nextpos);
		}

		if (1 != sign)
			ret.append("-");

		ret.reverse();

		return ret.toString();
	}
}
