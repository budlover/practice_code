/*
 * Count the number of 1 bits in a integer.
 */

#include<stdlib.h>
#include<stdio.h>

#define max(a,b) ((a)>(b)?(a):(b))

int binary_search_recursion(int arr[], int lo, int hi, int target)
{   

    if ((lo < 0) || (hi < 0) || (hi < lo)) return -1;
    
    int mid = lo + (hi - lo) / 2;
    
    if (arr[mid] == target)
        return mid;
    else if (arr[mid] < target)
        return binary_search_recursion(arr, mid + 1, hi, target);
    else
        return binary_search_recursion(arr, lo, hi - 1, target);
}

int main()
{
	int arr[] = {0, 10, 20, 36, 47, 58, 69, 70, 81, 91};
	int target = 91;

	int index = binary_search_recursion(arr, 0, 9, target);

	printf("index of %d is %d\n", target, index);

	return 0;
}
