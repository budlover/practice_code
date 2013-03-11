/*
 * get max size of the Rectangle among series of squares
 */
import java.util.Arrays;

public class maxRectangleSize {
	public static void main(String args[]) {
		int h[] = {1,20,1,1,20,20,1,1};

		System.out.println("max rectangle size is: " + maxRectSize(h));
	}

	private static int maxRectSize(int height[]) {
		int maxHeight = 0;
		for (int i = 0; i < height.length; i++) {
			if (height[i] > maxHeight) maxHeight = height[i];
		}

		int currentSize[] = new int[maxHeight + 1];
		int maxSize[] = new int[maxHeight + 1];

		int oldHeight = 0;
		int i, j;
		for (i = 0; i < height.length; i++) {
			if (height[i] >= oldHeight) {
				for(j = 1; j <= height[i]; j++)
					currentSize[j]++;
			} else {
				for (j = 1; j <= height[i]; j++)
					currentSize[j]++;

				for (; j<= oldHeight; j++) {
					if (currentSize[j] > maxSize[j])
						maxSize[j] = currentSize[j];
					currentSize[j] = 0;
				}
			}

			oldHeight = height[i];
		}

		int size = 0;
		for (i = 1; i<= maxHeight; i++) {
            if (currentSize[i] > maxSize[i])
                maxSize[i] = currentSize[i];

			if (maxSize[i] * i > size)
				size = maxSize[i] * i;
        }

		//System.out.println(Arrays.toString(maxSize));
		return size;
	}
}
