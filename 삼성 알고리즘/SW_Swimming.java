package SamsungExpert;

import java.util.Scanner;

public class SW_Swimming {
	static int n=0;
	static int price[]=new int[4];
	static int month[]=new int[12];
	static int cost=Integer.MAX_VALUE;
	public static void dfs(int m,int c)
	{
		if(m>=12)
		{
			cost=Math.min(cost, c);
			return;
		}
		
		dfs(m+1,c+month[m]*price[0]);//1일치
		dfs(m+1,c+price[1]);//1달
		dfs(m+3,c+price[2]);//3달
		dfs(m+12,c+price[3]);//1년
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int tc=scan.nextInt();
		for(int num=1;num<=tc;num++)
		{
			for(int i=0;i<4;i++)
				price[i]=scan.nextInt();
			for(int i=0;i<12;i++)
				month[i]=scan.nextInt();
			
			dfs(0,0);
			System.out.println("#"+num+" "+cost);
			cost=Integer.MAX_VALUE;
		}
	}

}
