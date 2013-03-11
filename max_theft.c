#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int get_max_three(int a, int b, int c)
{
	int tmp = a;

	tmp = b > tmp ? b : tmp;
	tmp = c > tmp ? c : tmp;

	return tmp;
}

int get_max_sum(int arr[], int len)
{
	int pre_1_sum = 0;
	int pre_2_sum = 0;
	int pre_3_sum = 0;
	int i;
	int tmp;

	for (i = 0; i < len; i++) {
		tmp = get_max_three(pre_1_sum, arr[i] + pre_2_sum, arr[i] + pre_3_sum);	
		pre_3_sum = pre_2_sum;
		pre_2_sum = pre_1_sum;
		pre_1_sum = tmp;
	}

	return pre_1_sum;
}

int main()
{
    int a[] = {1,1,100,100,1,1,100,1,1,100,1,1,100};
    printf("max sum is: %d\n", get_max_sum(a, sizeof(a)/sizeof(int)));

    return 1;
}
