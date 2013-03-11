/*
 * Find the smallest next number with same number of 1.
 */

#include<stdlib.h>
#include<stdio.h>

int main(int argc, char *argv[])
{
    unsigned int num, x;
	int c1 = 0;
	int c0 = 0;
	int shift = 0;
	int i;

    if (argc != 2) {
		printf("Input 1 para.\n");
        return -1;
	}
	
	if((x = (unsigned int)atoi(argv[1])) <= 0) {
		printf("It is not a number.\n");
		return -1;
	}
    
	num = x;

	if (0 == x)
		return -1;

	while ((x & 0x1) != 0x1) {
		c0++;
		x = x>>1;
	}

	while ((x & 0x1) == 0x1) {
		c1++;
		x = x>>1;
	}

	//printf("c0=%d, c1=%d\n", c0, c1);



	if (32 == c0 + c1)
		return -1;

	shift = c0 + c1;
    num |= 0x1 << shift;   // set 1
	num &= ~((0x1 << shift) - 1);  // clear 0
	
	for(i = 0; i < c1 - 1; i++)
		num |= 0x1 << i;

	printf("Smallest next number is %d\n", num);

	return num;
}

