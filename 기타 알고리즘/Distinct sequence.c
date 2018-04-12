#include <stdio.h>
#include <string.h>

int table[100][10000], arr[100][100];

void trace(int, int, int, int); 
void print();
void make_table();
char str[10000]; 
char sub[100];

void main()
{
	
	int i=0,j=0,n;
	int num=1;
	printf("How much ?\n");
	scanf("%d",&n);
	fflush(stdin);
	while(n>0)
	{
	printf("All String : ");
	gets(str);
	printf("Sub String : ");
	gets(sub);

	make_table();
	printf("%d\n", table[strlen(sub)][strlen(str)]);
	trace(strlen(sub), strlen(str), 0, 0);
	print();
	n--;
	}
}

void make_table()
{
	int i,j;
	for (i = 1; i <= strlen(sub); i++)
		table[i][0] = 0;
	for (i = 0; i <= strlen(str); i++)
		table[0][i] = 1;
	for (i = 1; i <= strlen(sub); i++)
	{
		for (j = 1; j <= strlen(str); j++)
		{
			if (sub[i-1]==str[j-1])
				table[i][j] = table[i - 1][j - 1] + table[i][j - 1];
			else
				table[i][j] = table[i][j-1];
		}
	}
}
void trace(int sublen, int strlen, int i, int j)
{
	if (sublen == 0|| strlen == 0)
		return;
	else if (table[sublen][strlen] == table[sublen - 1][strlen - 1] + table[sublen][strlen - 1])
	{
		if (table[sublen][strlen - 1] == 0)
		{
			arr[i][j] = strlen;
			trace(sublen - 1, strlen - 1, i, j+1);
		}
		else
		{
			arr[i][j] = strlen;
			trace(sublen - 1, strlen - 1, i, j+1);
			trace(sublen, strlen - 1, i + table[sublen-1][strlen-1], j);
		}
	}
	else
	{
		trace(sublen, strlen - 1, i, j);
	}
}

void print()
{
	int i,j;
	for (i = 0; i < table[strlen(sub)][strlen(str)]; i++)
	{
		printf("( ");
		for (j = strlen(sub)-1; j >= 0; j--)
		{
			if (arr[i][j] == 0)
				arr[i][j] = arr[i - 1][j];
			printf("%d ", arr[i][j]);
		}
		printf(")\n");
	}
}