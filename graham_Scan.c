#include<stdio.h>
#include <math.h>
#define pi 3.14159265
#define max 60
int top=-1;
int num;
struct point{
	double x;
	double y;
	double d;
}p[60],stack[60];
double degree(double,double);
double cal(double a,double b,double c,double d);
void push(struct point);
struct point pop();

void main()
{
	struct point tmp;
	double result,sum=0;
	int i,j;
	printf("What's the number of degree?\n");
	scanf("%d",&num);
	for(i=1;i<=num;i++)
	{
		scanf("%lf %lf",&p[i].x,&p[i].y);
	}
	//Theta value 
	for(i=1;i<=num;i++){
		if(p[i].x>=0&&p[i].y>=0||p[i].x<0&&p[i].y>=0)
			p[i].d = acos(p[i].x/sqrt(p[i].x*p[i].x+p[i].y*p[i].y));
		else if(p[i].x<0&&p[i].y<0||p[i].x>=0&&p[i].y<0)
			p[i].d= 2*pi-acos(p[i].x/sqrt(p[i].x*p[i].x+p[i].y*p[i].y));
	}
	//sorting
	for (i = 1 ; i <= num ; i++)
	{
		for (j = 1; j <= num-1; j++)
		{
			if (p[j].d > p[j + 1].d)
			{
				tmp = p[j + 1];
				p[j + 1] = p[j];
				p[j] = tmp;
			}
			else if (p[j].d==p[j+1].d)
			{
				if(p[j].x<p[j+1].x)
				{
					tmp=p[j+1];
					p[j+1]=p[j];
					p[j]=tmp;
				}
			}
		}
	}
	p[0].x=0;
	p[0].y=0;
	push(p[0]);
	push(p[1]);
	push(p[2]);

	for (i = 3; i <=num; i++)
	{
		if ( (p[i-2].x * p[i-1].y + p[i-1].x * p[i].y + p[i].x * p[i-2].y) - (p[i-2].x * p[i].y + p[i-1].x * p[i-2].y + p[i].x * p[i-1].y) > 0)
		{
			push(p[i]);
		}
		else
		{
			pop();
			push(p[i]);
		}
	}
	
	sum=cal(0,0,stack[0].x,stack[0].y);
	for(i=0;i<top;i++)
	{
		sum  = sum+cal(stack[i].x,stack[i].y,stack[i+1].x,stack[i+1].y);
	}
	printf("%.2f \n",sum+2);
}
void push(struct point e)
{
	stack[top++]=e;
}
struct point pop()
{
	stack[top--];
}
double cal(double a,double b,double c,double d)
{
	
	return sqrt((a-c)*(a-c)+(d-b)*(d-b));
}