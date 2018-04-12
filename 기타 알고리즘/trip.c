#include<stdio.h>
void sort(int a);
int money[100];
void main()
{
	int num,list[100],i;
	int sum=0,change=0;
	int avg=0,sum2=0;
	scanf("%d",&num);

	for(i=0;i<num;i++)
	{
		scanf("%d",&money[i]);
		sum+=money[i];
	}
	avg=sum/num;

	
		for(i=0;i<num;i++)
		{
			list[i]=avg-avg%10;
		}
		change=avg%10*num+sum%num;
		sort(num);
		for(i=0;i<change/10;i++)
		{
			list[i]+=10;
		}
		
		for(i=0;i<num;i++)
		{
			if(avg>money[i])
				sum2=sum2+list[i]-money[i];
		}

	
	printf("%d\n",sum2);
}
void sort(int num)
{
	int i,j,temp;
	for(i=0;i<num-1;i++)
    {
        for(j=0;j<num-1;j++)
        {
            if(money[j] < money[j+1])
            {
                temp=money[j];
                money[j]=money[j+1];
                money[j+1]=temp;
            }
        }
    }
}