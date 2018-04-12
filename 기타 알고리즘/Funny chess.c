#include<stdio.h>
#include<math.h>
#include<stdlib.h>
#define MAX 1000
int n,k,cnt;
int a[MAX],cnt=0;

void construct_candidates(int k,int c[],int *ncandidates);
int is_a_solution(int k,int count);
void bishop(int k,int count);

void main()
{
   printf("How much size?\n");
   scanf("%d",&n);
   if(n<1||n>10)
   {
      printf("Please enter the number 1<n<10 again \n");
      scanf("%d",&n);
   }
   printf("How many bishops?\n");
   scanf("%d",&k);
   if(k<0||k>n)
   {
      printf("Please enter the number again\n");
      exit(1);
   }
   bishop(0,0);
   printf("%d\n",cnt);
   
}

int is_a_solution(int p,int count)
{
   if(count==k)
   {
      cnt++;
      return 1;
   }
   if(p==2*n-1)
      return 1;
   return 0;
}

void bishop(int p,int count)
{
   int c[MAX],turn=0;
   int i,ncandidates;
   if(is_a_solution(p,count)==0)
   {
      p++;
      construct_candidates(p,c,&ncandidates);
      turn = 1;
      for(i=0;i<ncandidates;i++)
      {
         a[p] = c[i];
         if(c[i] != 0 && turn != 0)
         {
            count++;
            turn = 0;
         }
         if(count+2*n-1-p >= k)
            bishop(p,count);
      }
   }
}

void construct_candidates(int p,int c[],int *ncandidates)
{
   int ans = p,i,bns=0,t,turn,j;
       *ncandidates = 0;
   if(p>n)
      ans = 2*n-p;
   for(i=0;i<=ans;i++)
   {
      turn = 1;
      for(j=1;j<p && i!=0;j++)
      {
         if(p%2 != j%2)
            continue;
         if(a[j]==0)
            continue;
         if(j>n)
            bns=2*n-j;
         else
            bns = j;
         if(p>n && j>n)
         {
            t =(abs(j-p)/2);

            if(t+i==a[j])
               turn = 0;
         }
         else if(p>n && j<=n)
         {
            t = (abs(2*n-p-j)/2);
            if(2*n-p < j)
            {
               if(i+t==a[j])
                  turn = 0;
            }
            else if(i==t+a[j])
               turn = 0;
         }
         else if(p<=n && j<=n)
         {
            t = (abs(p-j)/2);
            if(t+a[j]==i)
               turn = 0;
         }
      }
      if(turn)
      {
         c[*ncandidates] = i;
         *ncandidates = *ncandidates+1;
      }
   }
}