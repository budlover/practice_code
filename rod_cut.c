/*
 * Count the number of 1 bits in a integer.
 */

#include<stdlib.h>
#include<stdio.h>

#define max(a,b) ((a)>(b)?(a):(b))

int get_max_rev_help(int rev[], int record[], int size)
{
    int max_value = -1;
	int i;

	if (0 <= record[size]) return record[size];
    
	if (0 == size) {
		max_value = 0;
	} else {
		for (i = 1; i <= size; i++)
			max_value = max(max_value, rev[i] + get_max_rev_help(rev, record, size - i));
	}

	record[size] = max_value;

    return max_value;
}

int get_max_rev(int rev[], int size)
{
	int record[size + 1];
	int i;
	int revnue;

	for (i = 0; i <= size; i++) record[i] = -1;
	revnue = get_max_rev_help(rev, record, size);

	return revnue;
}

int main(int argc, char *argv[])
{
	int rod_rev[11] = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

	if (2 != argc) {
		printf("Plz give me a rod size number.\n");
		return -1;
	}
	
	int size = atoi(argv[1]);
	if (0 > size) {
		printf("Need a positive number...\n");
		return -1;
	}

	if (10 < size) {
		printf("rod size should be <= 10.\n");
		return -1;
	}

	printf("The max revenue for size %d rod is %d.\n", size, get_max_rev(rod_rev, size));	

	return 0;
}
