public class replaceSpace {
	public static void main(String args[]) {
		char array[] = {'a','b',' ','d','e',' ','a','0','0','0', '0', '0'};

		replace(array, 7);

		System.out.println(array);
	}

	public static void replace(char array[], int length) {
		int spaceCount = 0;
		int newLength = 0;

		for (int i = 0; i < length; i++) {
			if (' ' == array[i])
				spaceCount++;
		}

		newLength = length + spaceCount * 2;
		if (newLength == length)
            return;

		int j = newLength - 1;
		array[newLength] = '\0';

		for (int i = length - 1; i >= 0; i--) {
			if (' ' != array[i]) {
				array[j] = array[i];
				j--;
			} else {
				array[j--] = '0';
				array[j--] = '2';
				array[j--] = '%';
			}
		}

		return;
	}
	


}
