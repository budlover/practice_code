public class numCountries {
	public static void main(String args[]) {
		int N = 3;
		int M = 3;
		int A[][] = {{1,1,1},{2,2,1},{1,1,1}};
		

		System.out.println("countries: " + countries(A));


	}

	public static int countries_recur(int A[][], int C[][], int N, int M, int row, int col, int z) {
    	int ret = 0;

    	if (0 != C[row][col] && z != C[row][col])
        	return -1;

    	if (z == C[row][col])
        	return 0;

    	// not been traverse yet
    	C[row][col] = z;

    	// go right
    	if (col + 1 < M) {
        	if (A[row][col] == A[row][col + 1]) {
            	ret = countries_recur(A, C, N, M, row, col + 1, z);
            	if (-1 == ret)
                	return -1;
        	}
    	}

    	// go down
    	if (row + 1 < N) {
        	if (A[row][col] == A[row + 1][col]) {
            	ret = countries_recur(A, C, N, M, row + 1, col, z);
            	if (-1 == ret)
                	return -1;
        	}
    	}

    	return 0;
	}

	public static int countries(int A[][]) {
    	int row, col;
		int N = A.length;
		int M = A[0].length;
    	int count = 0;
    	int C[][] = new int[N][M];
    	int z = 0;

    	for (row = 0; row < N; row++) {
        	for (col = 0; col < M; col++)
            	C[row][col] = 0;
    	}

    	for (row = 0; row < N; row++) {
        	for (col = 0; col < M; col++) {
            	z++;

            	if (0 != C[row][col])
                	continue;

            	if (0 == countries_recur(A, C, N, M, row, col, z))
                	count++;

        	}
    	}

    	return count;
	}
}
