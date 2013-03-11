/*
 * Count the number of 1 bits in a integer.
 */

#include<stdlib.h>
#include<stdio.h>

int main(int argc, char *argv[])
{
	int num;
    int count = 1;

    if (argc != 2) {
		printf("Input 1 para.\n");
        return -1;
	}
	
	if((num = atoi(argv[1])) <= 0) {
		printf("It is not a number.\n");
		return -1;
	}

	if (0 == num)
		printf("It is a 0.\n");

    while(1) {
		if ((num &= (num - 1)) == 0) {
			printf("has %d ge 1.\n", count);
			return count;
		}

		count++;
	}

    return -1;
}

