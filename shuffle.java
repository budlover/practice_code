import java.util.Arrays;
import java.util.Random;

public class shuffle {
	public static void main(String args[]) {
		int arr[] = {1,2,3,4,5};

		shuffle(arr);

		System.out.println(Arrays.toString(arr));
	}

	private static void shuffle(int arr[]) {
		int range = 5;
		Random rand = new Random();
		int swapindex;

		for (int i = arr.length - 1; i >= 0; i--) {
			swapindex = rand.nextInt(range);
			swap(arr, swapindex, i);

			range--;
		}

		return;

	}

	private static void swap(int arr[], int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];

		arr[y] = tmp;

		return;

	}
}
