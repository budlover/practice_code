import java.util.Arrays;

public class zeroRowCol {
	public static void main(String args[]) {
		int arr[][] = {{1,2,3},{3,0,1},{1,1,3}};

		zero(arr);
		for (int ar[] : arr)
			System.out.println(Arrays.toString(ar));
	}

	public static void zero(int array[][]) {
		int rowFlag[] = new int[array.length];
		int colFlag[] = new int[array[0].length];

		for (int r = 0; r < array.length; r++) {
			for (int c = 0; c < array[0].length; c++) {
				if (0 == array[r][c]) {
					rowFlag[r] = 1;
					colFlag[c] = 1;
				}
			}
		}

		for (int r = 0; r < array.length; r++) {
			if (0 != rowFlag[r]) {
				for(int i = 0; i < array[0].length; i++)
					array[r][i] = 0;
            }
        }

		for (int c = 0; c < array[0].length; c++) {
			if (0 != colFlag[c]) {
				for (int j = 0; j < array.length; j++)
					array[j][c] = 0;
			}
		}

		return;
	}
}
