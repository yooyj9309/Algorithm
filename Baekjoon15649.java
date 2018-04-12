package Algortihm2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Baekjoon15649 {
	static int n,m;
	static BufferedWriter bf=new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean visit[]=null;
	
	public static void dfs(int v,int len, int arr[]) throws IOException
	{
		if(len==m)
		{
			for(int a:arr)
				bf.write(a+" ");
			bf.newLine();
			bf.flush();
		}
		else{
			for(int i=1;i<=n;i++)
			{
				if(!visit[i])
				{
					visit[i]=true;
					arr[len]=i;
					dfs(i,len+1,arr);
				}
			}
		}
		visit[v]=false;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int arr[]=new int[m];
		visit=new boolean[n+1];
		dfs(0,0,arr);
	}

}
