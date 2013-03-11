#include<stdio.h>
#include<string.h>

int main()
{
	char *str = "abcdefghe";

	printf("unique?: %d\n", unique_chars(str, strlen(str)));
	return 0;
}

int unique_chars(char *str, int n)
{
	int flag = 0;
	int i;
	int ascii = 0;

	if  (26 <= n)
		return -1;

	for (i = 0; i < n; i++) {
		ascii = (int)(str[i] - 'a');
		if (0 != (flag & (1 << ascii)))
			return -1;

		flag |= 1 << ascii;
	}	

	return 0;
}
