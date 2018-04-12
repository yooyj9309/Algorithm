#include<stdio.h>
#include<string.h>

int search(int len,int);
int pan[30];
void flip(int );
int check(int);

void main()
{
	int i=0;
	int j=0;
	int k=0;
	int len=0,max=0;
	int l=1;
	printf("If you want to stop inputting, input 0\n");

	for(i=0;i<30;i++)
	{
		printf("pancake\n");
		scanf("%d",&pan[i]);
		if(pan[i]==0)
			break;
		j++;
	}
	len=j;

	while(check(j)!=1)
	{
		for(i=0;i<j;i++)
		{
			if(max<pan[i])
			{
				max=pan[i];
			}
		}

		if(max==pan[0])
		{
			flip(j-1);
			printf("flip(%d) ",l);
			l++;
		}
		else if(max==pan[j-1])
		{
			j--;
		}
		else
		{
			k=search(len,max);
			flip(len-k);
			printf("flip(%d) ",k);
		}

		max=0;
	}
	printf("flip(0)\n");

	for(i=0;i<len;i++)
		printf("%d ",pan[i]);
}
/*
This function is to search layer to have max.
*/
int search(int len,int max)
{
	int maxlayer=0;
	int i=0;
	for(i=0;i<len;i++)
	{
		if(max==pan[i])
		{
			maxlayer=len-i;
		}
	}
	return maxlayer;
}
/*
This function is to flip array with m.
*/
void flip(int m)
{
	int tmp=0;
	int i=0;
	for (i = 0; i<(m+1)/2; i++) 
	{
		tmp = pan[i];
		pan[i] = pan[m - i];
		pan[m - i] = tmp;
	}
}
/*
This function is to check whether correct or not.
*/
int check(int m)
{
	int i=0;
	while(i<m)
	{
		if(pan[i]<=pan[i+1])
			i++;
		else
		{
			return -1;
			break;
		}
	}
	return 1;
}