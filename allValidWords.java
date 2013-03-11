import java.util.ArrayList;

public class allValidWords{
	public static void main(String args[]) {
		String str = "hahahahaabcdeeee";
		ArrayList<String> dict = new ArrayList<String>();
		dict.add(new String("ehed"));
		dict.add(new String("zzzz"));
		dict.add(new String("yyyy"));

		ArrayList<String> permutations = findLongest(str, dict, 4);

		for (String strtmp : permutations)
            System.out.println(strtmp);
	}

	private static boolean dictValid(String str, ArrayList<String> dict) {
		for (String liststr : dict) {
			if (liststr.equals(str))
				return true;
		}
		
		return false;
	}

	private static boolean alreadyIn(ArrayList<String> permutations, String str) {
		for (String liststr : permutations) {
            if (liststr.equals(str))
                return true;
        }

        return false;
	}

	private static ArrayList<String> findLongest (String str, ArrayList<String> dict, int size) {
		char arr[] = new char[size];
		int used[] = new int[str.length()];  // all zeros

		ArrayList<String> permutations = new ArrayList<String>();
		getValidPermutations(str, arr, 0, used, permutations, dict);

		return permutations;
	}

	private static void getValidPermutations(String str, char arr[], int arrIndex, int used[], ArrayList<String> permutations, ArrayList<String> dict) {
		int next_used[] = new int[used.length];

		if (arrIndex == arr.length) {
			String tmpstr = "";
			for (char x : arr)
				tmpstr += x;

			if (dictValid(tmpstr, dict)) {
				if (!alreadyIn(permutations, tmpstr))
					permutations.add(tmpstr);
			}

			return;       
		}
       

		for (int i = 0; i < used.length; i++) {
			if (next_used[i] == 1)
				continue;

			next_used = used.clone();
			arr[arrIndex] = str.charAt(i);

			next_used[i] = 1;

			getValidPermutations(str, arr, arrIndex + 1, next_used, permutations, dict);   
		}

		return;
	}
}
