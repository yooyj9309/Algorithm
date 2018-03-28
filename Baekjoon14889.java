package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon14889 {
	static int map[][]=null;
	static int n=0,ans=Integer.MAX_VALUE;
	static boolean[] visit=null;
	public static void dfs(int v, int len)
	{
		if(len==n/2)
			divide();
		else
		{
			for(int i=v+1;i<=n;i++)
			{
				if(!visit[i])
				{
					visit[i]=true;
					dfs(i,len+1);
				}
			}
		}
		visit[v]=false;
	}
	public static void divide()
	{
		int a[]=new int[n/2+1];
		int b[]=new int[n/2+1];
		int k=1,j=1;
		
		for(int i=1;i<=n;i++)
		{
			if(visit[i])
				a[k++]=i;
			else
				b[j++]=i;
		}
		int numA=getNum(a);
		int numB=getNum(b);
		
		int value=Math.abs(numA-numB);
		if(ans>value)
			ans=value;
	}
	public static int getNum(int a[])
	{
		int num=0;
		for(int i=1;i<a.length;i++)
			for(int j=i+1;j<a.length;j++)
			{
				num+=map[a[i]][a[j]];
				num+=map[a[j]][a[i]];
			}
		return num;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(in.readLine());
		map=new int[n+1][n+1];
		visit=new boolean[n+1];
		for(int i=1;i<=n;i++)
		{
			String tmp[]=in.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				map[i][j+1]=Integer.parseInt(tmp[j]);
			}
		}
		dfs(0,0);
		System.out.println(ans);
	}

}
