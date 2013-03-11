import java.util.ArrayList;
import java.util.Arrays;

public class longIncreaseSequence {
	public static void main(String args[]) {
		int arr1[] = {1,10,3,4,10,6,6,10,8,9};
		int arr2[] = arr1.clone();
		Arrays.sort(arr2);	

		ArrayList<Integer> list = getCommonSeq(arr1, arr2);

		for (Integer x : list)
			System.out.print(x + ", ");
		System.out.println();
	}

	private static ArrayList<Integer> getCommonSeq(int arr1[], int arr2[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		getCommonSeqRecur(arr1, arr2, arr1.length - 1, arr2.length - 1, list);

		return list;
	}

	private static int getCommonSeqRecur(int arr1[], int arr2[], int index1, int index2, ArrayList<Integer> list) {
		if (0 > index1 || 0 > index2)
			return 0;

		int retVal, retVal2;
		ArrayList<Integer> tmplist = new ArrayList<Integer>();
		ArrayList<Integer> tmplist2 = new ArrayList<Integer>();

		if (arr1[index1] == arr2[index2]) {
			retVal = getCommonSeqRecur(arr1, arr2, index1 - 1, index2 - 1, tmplist) + 1;
			list.addAll(tmplist);
			list.add(arr1[index1]);
			
			return retVal;
		} else {
			retVal = getCommonSeqRecur(arr1, arr2, index1 - 1, index2, tmplist);
			retVal2 = getCommonSeqRecur(arr1, arr2, index1, index2 - 1, tmplist2);
			if (retVal > retVal2) {
				list.addAll(tmplist);
				return retVal;
			} else {
				list.addAll(tmplist2);
                return retVal2;
			}
		}
	}
}

