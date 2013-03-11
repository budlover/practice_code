public class findPrimeNumber {
	public static void main(String args[]) {
		for (int i = -1; i < 10; i++) {
			System.out.println(i + "'s next prime num is: " + nextPrimeNumber(i));
		}
	}
	
	private static int nextPrimeNumber(int n) {
		int i = n + 1;
		while (!isPrime(i)) i++;

		return i;	
	}

	private static boolean isPrime (int n)
	{
		if (1 >= n)
			return false;

		int up = (int) Math.sqrt(n);  

		for (int i = 2; i <= up; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}
}
