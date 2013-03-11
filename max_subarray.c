// find out the sum of the "maximum subarray"

#include <stdio.h>

int max_subarray (int arr[], int size)
{
	int max;
	int tmp_sum = 0;
	int i;

	if (0 >= size) return 0xffffffff;
	if (1 == size) return arr[0];

	max = arr[0];
	for (i = 0; i < size; i++) {
		if (tmp_sum < 0) tmp_sum = arr[i]; // reset start point
		else tmp_sum += arr[i];            // try this one makes sum still >0 or not
		if (max < tmp_sum) max = tmp_sum;
	}
	
	return max;
}
int main()
{
	int arr[] = {1,-2,-4,-4,100};
	int sum = max_subarray(arr, sizeof(arr) / sizeof(int));
	printf("sum = %d\n", sum);
	
	return 0;
}


