// malloc a two dimensional array, return the pointer "arr" of the array so that the array can be accessed by "arr[i][j]"

#include <stdlib.h>
#include <stdio.h>

int **two_demension_array (int row, int col)
{
	int i;
	int *arr;

	if (0 >= row || 0 >= col)
		return NULL;

	if (NULL == (arr = (int *)malloc(row + row * col)))
		return NULL;
	
	for (i = 0; i < row; i++)
		arr[i] = (int)arr + row + i * col;

	return (int **)arr;
}

int main()
{
	int **arr = two_demension_array(4, 5);
	arr[1][2] = 15;
	printf("%d, %d\n", arr[1][2], arr[3][4]);

	free(arr);

	return 0;
}


