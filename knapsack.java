// knapsack problem
// the key is V[n][w] = max{V[n - 1][w - weight[n]] + value[n], V[n - 1][w]}

public class knapsack {
	public static void main(String args[]) {
		if (2 != args.length) {
			System.out.println("Please give me # of items and the limit of weight!");
			return;
		}

		int N = Integer.parseInt(args[0]);   // number of items
        int W = Integer.parseInt(args[1]);   // maximum weight of knapsack

        int[] value = new int[N + 1];
        int[] weight = new int[N + 1];

        // randomly generate weight and values 1..N
        for (int n = 1; n <= N; n++) {
            value[n] = (int) (Math.random() * 10);
            weight[n] = (int) (Math.random() * W);
		}

		int maxValue[][] = new int[N + 1][W + 1];
		boolean takeOrNot[][] = new boolean[N + 1][W + 1];

		for (int n = 1; n <= N; n++) {
			for (int w = 1; w <= W; w++) {
				if (weight[n] > w) { // not take nth item
					maxValue[n][w] = maxValue[n - 1][w];
					takeOrNot[n][w] = false;
					continue;
				}

				int takeYes = maxValue[n - 1][w - weight[n]] + value[n];
				int takeNo = maxValue[n - 1][w];

				maxValue[n][w] = takeYes > takeNo ? takeYes : takeNo;
				takeOrNot[n][w] = takeYes > takeNo ? true : false;
			}
		}

		boolean take;
		int remain = W;
		// print the result
		for (int i = N; i >= 1; i--) {
			System.out.println("w: " + weight[i] + " v: " + value[i] + " take: " + takeOrNot[i][remain]);
			
			if (false != takeOrNot[i][remain])
				remain -= weight[i];
		}
		
		System.out.println("max value is: " + maxValue[N][W]);
	}
}
