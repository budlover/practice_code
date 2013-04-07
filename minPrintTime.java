import java.lang.Math;
import java.util.Arrays;

public class minPrintTime {
	public static void main(String args[]) {
		int a[] = {1000,1,1,1,1,1};
		int numPrinter = 3;

		System.out.println(minTime(a, numPrinter));
	}

	static int minTime(int a[], int numPrinter) {
		int k = numPrinter;

		if (a.length <= k) {
			Arrays.sort(a);
			return a[a.length - 1];
		}

		
		return minTimeRecur(a, a.length, k);
	}

	private static int minTimeRecur(int a[], int n, int k) {
		//base case
		if (1 == n)
			return a[0];

		if (1 == k)
			return sum(a, 0, n - 1);

		int mintime = 9999999;
		for (int i = 1; i <= n; i++) {
			mintime = Math.min(mintime, Math.max(minTimeRecur(a, i, k - 1), sum(a, i, n - 1)));
		}

		return mintime;
	}

	private static int sum(int a[], int from, int to) {
		int sum = 0;
		for (int i = from; i <= to; i++) 
			sum += a[i];

		return sum;
	}
}
