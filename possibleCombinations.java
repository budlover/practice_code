// still need to remove repeating senarios

import java.util.ArrayList;
import java.util.Arrays;

public class possibleCombinations {
	public static void main(String args[]) {
		possibleCombinations1 comb = new possibleCombinations1();

        ArrayList<ArrayList<Integer>> lists = comb.combination(10);

        for (ArrayList<Integer> list : lists) {
            for (Integer i : list)
                System.out.print(i + ", ");

			System.out.print("\n");
        }
    }
}


class possibleCombinations1 {
	public int base[] = {2,3,5};
	
	public ArrayList<ArrayList<Integer>> combination(int sum) {
		Arrays.sort(base);
		if (sum < base[0])
			return null;

		ArrayList<ArrayList<ArrayList<Integer>>> dp = new ArrayList<ArrayList<ArrayList<Integer>>>();
		for (int i = 0; i < sum + 1; i++)
			dp.add(i, null);

		ArrayList<ArrayList<Integer>> retLists = combination_helper(sum, dp);

		//for (ArrayList<ArrayList<Integer>> lists : dp) {
		//	System.out.print("\n\n");
		//	for (ArrayList<Integer> list : lists) {
		//		for (Integer i : list)
		//			System.out.print(i + ", ");
		//	}
		//}


		return retLists;
	}

	public ArrayList<ArrayList<Integer>> combination_helper(int sum, ArrayList<ArrayList<ArrayList<Integer>>> dp) {
		if (0 > sum)
			return null;
		
		if (0 == sum) {
			//System.out.println("sum: " + sum);
			return new ArrayList<ArrayList<Integer>>();
		}

		//System.out.println("dp size: " + dp.size());

		ArrayList<ArrayList<Integer>> retLists = new ArrayList<ArrayList<Integer>>();
		if (null != dp.get(sum)) {
			retLists.addAll(dp.get(sum));
			return retLists;
		}

		for (int i : base) {
			ArrayList<ArrayList<Integer>> lists = combination_helper(sum - i, dp);
			if (null == lists) {
				//System.out.println("sun: " + sum + "i: " + i);
				continue;
			}

			if (0 == lists.size()) {
				ArrayList<Integer> tmplist = new ArrayList<Integer>();
				tmplist.add(i);
				retLists.add(tmplist);
			} else {
				ArrayList<Integer> tmpList = new ArrayList<Integer>();
				for (ArrayList<Integer> list : lists) {
					tmpList = (ArrayList<Integer>)list.clone();
					tmpList.add(i);
					retLists.add(tmpList);
				}
			}
		}

		if (0 == retLists.size())
			return null;
		//System.out.println("sum: " + sum);	

		// record and return;
		dp.set(sum, retLists);
		return retLists;
	}
}
