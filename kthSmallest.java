public class kthSmallest{
	public static void main(String args[]) {
		int arr1[] = {1,3,5,6,9};
		int arr2[] = {2,4,6,8,10};

		System.out.println(find(arr1, arr2, 11));

	}

	static int find(int arr1[], int arr2[], int k) {
		int i1 = -1;
		int i2 = -1;
		int c = 0;
		int tmp = 0;

		if (0 >= k || k > arr1.length + arr2.length)
			return -1;

		while (c < k) {
			if (i1 >= arr1.length - 1) {
				i2++;
				tmp = arr2[i2];
			} else if (i2 >= arr2.length - 1) {
				i1++;
				tmp = arr1[i1];
			} else {
				if (arr1[i1 + 1] >= arr2[i2 + 1]) {
					i2++;
					tmp = arr2[i2];
				} else {
					i1++;
					tmp = arr1[i1];
				}
			}

			c++;
		}

		return tmp;
	}
}
