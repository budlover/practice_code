/*
 * find the largest previous number with same number of 1.
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
	
	if ((num == 0) || (num == ~0x0)) return -1;

	while ((x & 0x1) == 0x1) {
		c1++;
		x = x>>1;
	}

	while ((x & 0x1) != 0x1) {
		c0++;
		x = x>>1;
		if (32 == (c0 + c1)) return -1;
	}
	
	shift = c0 + c1;
	num &= ~(0x1 << shift);
	num &= ~((0x1 << shift) - 1);

	for (i = 0; i < c1+1; i++)
		num |= 0x1<<(shift - i -1);

	printf("The previous largest number is %d\n", num);

	return num;
}

