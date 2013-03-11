/*
 * There are duplicate numbers in the array
 */

#include<stdlib.h>
#include<stdio.h>

#define max(a,b) ((a)>(b)?(a):(b))

int main()
{
	int size = 12;
	int array[12] = {1,1,2,2,3,3,4,4,4,4,5,5};
	int target = 4;

	int low = 0;
	int high = size - 1;
	int mid = low + (high - low) / 2;
	
	while (low <= high) {
		mid = low + (high - low) / 2;

		if (array[mid] <= target)
			low = mid + 1;
		else
			high = mid - 1;

		//printf("low %d, high %d\n", low, high);
	}

	if (array[low - 1] == target) {
		printf("%d is found, the index is %d\n", target, low - 1);
		return low - 1;
	}

	printf("%d is not found.\n", target);
	return -1;
}
