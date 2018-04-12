package Algortihm2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Binary_matching {
	static int N,M;
	static int a[];
	static int b[];
	static boolean visited[];
	final static int max=200;
	static ArrayList<Integer> adj[]=new ArrayList[max];
	
	public static boolean dfs(int k)
	{
		visited[k]=true;
		for(int i=0;i<adj[k].size();i++)
		{
			if(b[i]==-1||!visited[b[i]]&&dfs(b[i]))
			{
				a[k]=i;
				b[i]=k;
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		visited=new boolean[max];
		a=new int[max];
		b=new int[max];
		for(int i=0;i<max;i++)
			adj[i]=new ArrayList<Integer>();
		for(int i=0;i<N;i++)
		{
			int S=sc.nextInt();
			for(int j=0;j<S;j++)
			{
				int k=sc.nextInt();
				adj[i].add(k-1);
			}
		}
		
		int match=0;
		Arrays.fill(a, -1);
		Arrays.fill(b, -1);
		
		for(int i=0;i<N;i++)
		{
			if(a[i]==-1)
			{
				Arrays.fill(visited, false);
				if(dfs(i))
					match++;
			}
		}
		sc.close();
		System.out.println(match);
		
	}
	
}
