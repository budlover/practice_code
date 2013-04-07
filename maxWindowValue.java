import java.util.PriorityQueue;

public class maxWindowValue {
	public static void main(String args[]) {
        int arr[] = {10,9,8,7,6,5,100};
        int w = 3;
		
		heihei cl = new heihei();

		int B[] = cl.windowmax(arr, w);
		for (int i : B)
        	System.out.print(i + " ");
		System.out.println(" ");
    }


}

class heihei {
	private class pair implements Comparable<pair> {
		public int value;
		public int index;

		public pair(int a, int b) {
			this.value = a;
			this.index = b;
		}

		public int compareTo(pair other) {
			if (this.value > other.value)
				return 1;
			else if (this.value < other.value)
				return -1;
			else
				return 0;
		}
	}

	public int[] windowmax(int arr[], int w) {
		if (arr.length - w + 1 <= 0)
			return null;

		PriorityQueue<pair> pq = new PriorityQueue<pair>();
		int B[] = new int[arr.length - w + 1];
		for (int i = 0; i < w; i++) 
			pq.offer(new pair(arr[i], i));

		pair tmp;
		int i;
		for (i = w; i < arr.length; i++) {
			tmp = pq.peek();
			B[i - w] = tmp.value;
			while(tmp.index <= i - w) {
				pq.poll();
				tmp = pq.peek();
			}

			pq.offer(new pair(arr[i], i));
		}

		// one more time here
		B[i - w] = pq.peek().value;

		return B;
	}
}
