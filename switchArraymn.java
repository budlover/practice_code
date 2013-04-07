import java.util.Arrays;

public class switchArraymn {
	public static void main(String args[]) {
		int arr[] = {1,2,3,4,5,6,7,8};
		switch1(arr, 3,5);

		System.out.println(Arrays.toString(arr));

	}
	
	private static void switch1(int arr[], int m, int n) {
		if (arr.length != m + n)
			return;
	
		int i;
		int tmp;
		for (i = 0; i < arr.length / 2; i++) {
			tmp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = tmp;
		}

		for (i = 0; i < n / 2; i++) {
			tmp = arr[i];
			arr[i] = arr[n - i -1];
			arr[n - i - 1] = tmp;
		}

		for (i = 0; i < m / 2; i++) {
			tmp = arr[n + i];

			arr[n + i] = arr[arr.length - i -1];
			arr[arr.length - i - 1] = tmp;
		}

		System.out.println("here");

		return;
			

	}

}

