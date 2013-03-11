/*
 * Count the number of 1 bits in a integer.
 */

#include<stdlib.h>
#include<stdio.h>

int fibonacci(int index)
{
	if (0 > index) return 0;
	else if ((0 == index) || (1 == index)) return 1;
	else {return fibonacci(index - 1) + fibonacci(index - 2);}
}

int main(int argc, char *argv[])
{
	if (2 != argc) {
		printf("Plz give me a number.\n");
		return -1;
	}
	
	int index = atoi(argv[1]);
	if (0 > index) {
		printf("Need a positive number...\n");
		return -1;
	}

	printf("The %dth one in Fibonacci array is %d\n", index, fibonacci(index));

	return 0;
}
