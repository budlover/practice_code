/**
 * alloc space that aligned to power of 2
 */

#include <stdlib.h>
#include <stdio.h>

void *aligned_malloc (int size, int align)
{
	int more_space = align - 1 + sizeof(void *);
	void *p1;
	void **p2;

	if (NULL == (p1 = malloc(size + more_space)))
		return NULL;

	p2 = (void *)(((int)p1 + more_space) & (~(align - 1)));
	p2[-1] = p1; // store the address returned by malloc
	
	return (void *)p2;
}

void aligned_free(void *p)
{
	int *p1 = ((void **)p)[-1];
	free(p1);

	return;
}

int main()
{
	void *p1 = aligned_malloc(120, 4);
	printf("address: %p\n", p1);

	aligned_free(p1);

	return 0;
}


