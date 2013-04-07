public class maxRectangleSize2 {
	public static void main(String args[]) {
		int arr[] = {1,2,3,4,5};

		System.out.println(maxRect(arr));
	}

	static int maxRect(int ht[]) {
		if (null == ht)
			return -1;

		if (ht.length == 0)
			return 0;

		int i;
		int max = 0;
		for (i = 0; i < ht.length; i++) {
			//go right
			int j;
			int count = 1;
			for (j = i + 1; j < ht.length; j++) {
				if (ht[j] < ht[i])
					break;

				count++;
			}

			//go left
			for (j = i - 1; j >= 0; j--) {
				if (ht[j] < ht[i])
					break;

				count++;
			}

			max = count * ht[i] > max ? count * ht[i] : max;
		}

		return max;
	}
}
