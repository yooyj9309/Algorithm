#include<stdio.h>
#include<time.h>
#include<stdlib.h>
int repeat(int a,int b,int n);
int miler();

void main()
{
	int k=0,q=0,n=0,a,t=0;
	int i,j;
	int square=1;
	printf("Input your N\n");
	scanf("%d",&n);
	
	if(miller(n)==-1)
		printf("The number %d is a Carmichael number.\n",n);
	else if(miller(n)==1)
		printf("%d is normal\n",n);

}
int repeat(int a,int b,int n)
{
	int c=0,d=1;
	int i=0,j=0;
	int temp[100];
	for(i=0;b>0;i++)
	{
		temp[i]=b%2;
		b=b/2;
		c=2*c;
		d=(d*d)%n;
		if(temp[i]==1)
		{
			c=c+1;
			d=(d*a)%n;
		}
	}

	return d;
}
int miller(int n)
{
	int a;
	srand(time(NULL));
	a=rand()%(n-3)+2;
	if(!repeat(a,n,n)==a)
	{
		return -1;
	}
	else
	{
		if(prime(n)==1)
			return 1;
		else
			return -1;
	}

}
int prime(int n)
{
	int i;
	for(i=2;i<n;i++)
	{
		if(n%i==0)
			return -1;
	}
	return 1;
}
