import java.util.Stack;

public class medianOfTwoArrays {
	public static void main(String args[]) {
		int arr1[] = {1,2,3,4};
		int arr2[] = {5,6,7,8};

		System.out.println(getMedian(arr1, arr2));
	}

	private static float getMedian(int arr1[], int arr2[]) {
		Stack<Integer> st = new Stack<Integer>();
		int c1 = 0;
		int c2 = 0;
		int stop = (arr1.length + arr2.length) / 2 + 1;
		int count = 0;

		while (c1 + c2 < stop) {
			if (c1 > arr1.length - 1) {
				st.push(arr2[c2]);
				c2++;
			} else if (c2 > arr2.length - 1) {
				st.push(arr1[c1]);
				c1++;
			} else {
				if (arr1[c1] >= arr2[c2]) {
					st.push(arr2[c2]);
					c2++;
				} else {
					st.push(arr1[c1]);
					c1++;
				}
			}

			count++;
		}

		float ret = 0;
		if (0 == (arr1.length + arr2.length) % 2) {
			float x = st.pop();
			float y = st.pop();
			ret = (x + y) / 2;
		} else {
			ret = st.pop();
		}

		return ret;
	}
}
