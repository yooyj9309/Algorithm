#include<stdio.h>

int link[30][30];
int color[30];
int type,vertex;
void bicoloring(int, int);
void main()
{
	int i,j,n1,n2;
	printf("How many vertex?\n");
	scanf("%d",&vertex);
	for(i=0;i<vertex;i++)
	{
		for(j=0;j<vertex;j++)
			link[i][j]=0;
	}
	for(i=0;i<vertex;i++)
	{
		scanf("%d %d",&n1,&n2);
		link[n1][n2]=1;
		link[n2][n1]=1;
	}

	for(j=0;j<vertex;j++)
	{
		color[j]=0;
		type = 1;
		bicoloring(0,1);
	}
	if(type ==0)
		printf("Not two color graph\n");
	else
		printf("Two color graph\n");
}
void bicoloring(int n,int c)
{
	int i;
	color[n]=c;
	for(i=0;i<vertex&&type;i++)
	{
		if(link[n][i]==0)     //not connecting
			continue;
		if(color[i]==0)        //
			bicoloring(i,c%2+1);
		else
		{
			if(color[i]==c)
			{
				type = 0;
				return;
			}
		}
	}
}
