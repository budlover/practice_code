/*
 * get max value of treasure you can rob
 */
public class maxRobbery {
	public static void main(String args[]) {
		int treasure[] = {1,1,1,1,1,1,1,200,1,1000,1};

		System.out.println("The max money you can rob is: " + maxRob(treasure));
	}

	private static int maxRob(int arr[]) {
		int pre_1_max = 0;
		int pre_2_max = 0;
		int pre_3_max = 0;
		int this_max = 0;

		for (int i = 0; i < arr.length; i++) {
			this_max = maxOfThree(pre_1_max, pre_2_max + arr[i], pre_3_max + arr[i]);
			pre_3_max = pre_2_max;
			pre_2_max = pre_1_max;
			pre_1_max = this_max;
		}

		return maxOfThree(pre_1_max, pre_2_max, pre_3_max);
	}

	private static int maxOfThree(int a, int b, int c) {
		int tmp = a > b ? a : b;
		tmp = tmp > c ? tmp : c;

		return tmp;
	}
}
