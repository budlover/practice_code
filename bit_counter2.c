/*
 * Count the number of 1 bits in a integer.
 */

#include<stdlib.h>
#include<stdio.h>

int main(int argc, char *argv[])
{
	int shift;
	int num;

    if (argc != 2) {
		printf("Input 1 para.\n");
        return -1;
	}
	
	if((num = atoi(argv[1])) <= 0) {
		printf("It is not a number.\n");
		return -1;
	}

    shift = (num & 0x55555555) + ((num >> 1) & 0x55555555);
	shift = (shift & 0x33333333) + ((shift >> 2) & 0x33333333);
	shift = (shift & 0x0f0f0f0f) + ((shift >> 4) & 0x0f0f0f0f);
	shift = (shift & 0x00ff00ff) + ((shift >> 8) & 0x00ff00ff);
	shift = (shift & 0x0000ffff) + ((shift >> 16) & 0x0000ffff);

	printf("%d ge 1 in %d.\n", shift, num);

    return shift;
}

