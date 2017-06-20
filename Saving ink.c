//Using kruskal Algorithm
#include <stdio.h>
#include <math.h>
struct Point{
	double x;
	double y;
}p[30];
struct Point tmp;
void sort(int);
void make_table(int);
double table[30][30];
void main()
{
	int num,i,j;
	double len = 0,len1=0,min;
	printf("What's num(1<x<30)? : ");
	scanf("%d",&num);


	printf("input (x,y) \n");

	for(i=0;i<num; i++)
	{
		scanf("%lf %lf",&p[i].x,&p[i].y);
	}
	sort(num);
	make_table(num);

	for(i=0;i<num; i++)
	{
		min=9999;
		for(j=i+1; j<num;j++)
			if((min>table[i][j]))
				min=table[i][j];
		len=len+min;
	}

	for(i=0;i<num; i++)
	{
		min=9999;
		for(j=0; j<i;j++)
		{
			if((min>table[i][j]))
				min=table[i][j];
		}
		len1=len1+min;
	}

	if(len<len1)
		printf("%.2lf\n",len-9999);
	else
		printf("%.2lf",len1-9999);
}
void sort(int number)
{
	int i,j;

	for(i=0;i<number;i++)
	{
		for(j=i+1;j<number;j++)
		{
			if(p[i].x>p[j].x)
			{
				tmp = p[i];
				p[i]=p[j];
				p[j]=tmp;
			}
		}
	}
}
void make_table(int num)
{
	int i,j;
	for(i=0;i<num; i++)
		for(j=0; j<num;j++)
			table[i][j]=sqrt(((p[i].x-p[j].x)*(p[i].x-p[j].x))+((p[i].y-p[j].y)*(p[i].y-p[j].y)));
}