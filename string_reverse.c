#include <stdlib.h>
#include <stdio.h>

void reverse_string(char *str)
{
	if (NULL == str)
		return;

	int len = 0;
	char *ptr = str;
	int i;
	char tmp;

	while('\0' != *ptr) {
		ptr++;
		len++;
	}

	for (i = 0; i < len / 2; i++) {
		tmp = str[i];
		str[i] = str[len - i -1];
		str[len - i - 1] = tmp;
	}

	return;
}

int main()
{
    char str[] = "abcdefgaaa";

    reverse_string(str);

    printf("reverse: %s\n", str);
    return 0;
}
