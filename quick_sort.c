/* quick sort */
#include <stdio.h>

void swap(int *a, int *b)
{
	int tmp = *a;
	*a = *b;
	*b = tmp;

	return;
}

void qsort (int arr[], int left, int right)
{
	int l = left + 1;
	int r = right;
	int pivot;
	
	if ((0 >= right) || (left >= right)) return;

	pivot = arr[left];

	while(l <= r) {
		if (arr[l] <= pivot) {
			l++;
		} else {
			swap(&arr[l], &arr[r]);
			r--;
		}
	}

	swap (&arr[left], &arr[l - 1]);
	qsort (arr, left, l - 2);
	qsort (arr, l, right);
}

int main()
{
	int i;
	int a[] = {100,29,9,11,11,22,22,33,33,44,55};
	int size = sizeof(a)/sizeof(int);
	qsort(a, 0, size - 1);

	for (i = 0; i < size; i++) printf("%d,", a[i]);
	
	printf("\n");
	
	return 0;
}


