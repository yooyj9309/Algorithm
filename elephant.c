#include<stdio.h>
struct elephant{
	int index;
	int weight;
	int iq;
} ele[1000];
void sort(int);
void make_table(int);

int table[100][100]={1,};
int result[100];
void main()
{
	int elenum,i,j,num=0,min,max=0;
	int k=0;
	int tmp;
	printf("What's num elephant?\n");
	scanf("%d",&elenum);

	for(i=0;i<elenum;i++)
	{
		ele[i].index=i+1;
		scanf("%d",&ele[i].weight);
		scanf("%d",&ele[i].iq);
	}
	sort(elenum);

	make_table(elenum);

	for(i=0;i<elenum;i++)
	{
		printf("\n");
		for(j=0;j<elenum;j++)
		{
			printf("%d ",table[i][j]);
		}
	} // print table

	for(i=0;i<elenum;i++)
	{
		if(max<table[elenum-1][i])
		{
			max=table[elenum-1][i];
			tmp=i;
		}
	}
	printf("\n%d\n",max);

	for(i=elenum;i>=0;i--)
	{
		if(table[i][tmp]!=table[i-1][tmp])
		{
			result[k]=i;
			k++;
		}
	}
	for(i=k-1;i>=0;i--)
		printf("%d\n",ele[result[i]].index);
}


void sort(int a)
{
	int i,j;
	struct elephant tmp;
	for(i=0;i<a;i++)
	{
		for(j=0;j<a-1;j++)
		{
			if(ele[j].weight>ele[j+1].weight)
			{
				tmp=ele[j];
				ele[j]=ele[j+1];
				ele[j+1]=tmp;
			}
		}
	}
}

void make_table(int elenum)
{
	int min=0,i,j;

	for(j=0;j<elenum;j++)
	{
		min=ele[j].iq;
		for(i=j;i<elenum;i++)
		{

			if(i==j)
				table[i][j]=1;

			if(ele[i].weight != ele[i+1].weight)
			{
				if(min>ele[i].iq)
				{
					min=ele[i].iq;
					table[i][j]=table[i-1][j]+1;
					i--;
				}
				else 
					table[i+1][j]=table[i][j];
			}
			else if(ele[i].weight==ele[i+1].weight)
			{
				table[i+1][j]=table[i][j];
			}
		}
	}
}
