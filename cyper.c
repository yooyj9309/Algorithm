#include<stdio.h>
int repeat(int,int,int);
int euclid(int,int);
void main()
{
	int p,q,e=0,d=0;
	int n=0,pin=0,m=0;
	int i,j;
	printf("Prime number : p ,q\n");
	scanf("%d %d",&p,&q);
	printf("What do you want to input message?\n");
	scanf("%d",&m);
	n=p*q;
	pin=(p-1)*(q-1);
	
	for(i=1;i<100;i++)
	{
		if((pin%(2*i+1)!=0)&&(euclid(pin,2*i+1)==1)){
			e=2*i+1;
			break;
		}
	}
	
	i=1;
	for(i=1;i<100;i++)
	{
		if((i*pin+1)%e==0){
			d=(i*pin+1)/e;
			break;
		}
	}
	printf("Public key : %d,%d\n",e,n);
	printf("Secret Key : %d,%d\n",d,n);
	printf("encryption message : %d \n",repeat(m,e,n));
}
int repeat(int a,int b,int n)
{
	int c=0,d=1;
	int i=0,k=0,j=0;
	int temp[100],result[100];
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
int euclid(int a,int b)
{
	if(b==0)
		return a;
	else
		return euclid(b,a%b);
}