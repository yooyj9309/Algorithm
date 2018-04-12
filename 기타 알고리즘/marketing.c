#include<stdio.h>
#include<math.h>
struct point{
	double x;
	double y;
};

int k=0;
double closet(struct point [],int,int);
double cal(struct point[],struct point[]);
double brute(struct point [],int ,int);

void main()
{
	int i,num,j;
	struct point tmp,p[30];
	printf("What's the number of pointer?\n");
	scanf("%d",&num);

	for(i=0;i<num;i++)
	{
		printf("%d pointers x, y\n",i+1);
		scanf("%lf %lf",&p[i].x,&p[i].y);
	}

	for(i=0;i<num;i++)
	{
		for(j=0;j<num-i-1;j++)
		{
			if(p[j].x>p[j+1].x)
				{	
					tmp=p[j+1];
					p[j+1]=p[j];
					p[j]=tmp;
				}
		}
	}
	
	printf("%0.2lf ",closet(p,0,num-1));

}

double closet(struct point p[],int l,int r)
{
	int q=0,i ,j;
	double dl=0,dr=0,d,min;
	struct point tmp,s[30];
	if((r-l)<3)
	{
		return brute(p,l,r);
	}

	if((l+r)%2==0)
		q=(l+r)/2;
	else
		q=(l+r)/2+1;

	
	dl=closet(p,l,q-1);
	dr=closet(p,q,r);

	if(dl>dr)
		d=dr;
	else
		d=dl;
	for(i=l;i<=r;i++)
	{
		if((p[q].x - d <=p[i].x)&&(p[i].x<=p[q].x + d))
			{
				s[k]=p[i];
				k++;
			}
	}
	for(i=0;i<k;i++)
	{
		for(j=0;j<k-i-1;j++)
		{
			if(s[j].y>s[j+1].y)
				{	
					tmp=s[j+1];
					s[j+1]=s[j];
					s[j]=tmp;
				}
		}
	}
	if(d>brute(s,0,k-1))
		d=brute(s,0,k-1);
	return d;
}
double cal(struct point a,struct point b)
{
	double result=0;
	return sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
}
double brute(struct point t[],int l, int r)
{
	int i,j;
	double min=100000,result=0;
	for(i=l;i<r;i++)
	{
		for(j=i;j<=r;j++)
		{
			result=cal(t[i],t[j+1]);
			if(min>result&&result!=0)
				min=result;
		}
	}
	return min;
}