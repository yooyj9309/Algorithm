package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon11375 {

	static boolean map[][];
	static boolean visited[];
	static int employee[];
	static int job[];
	static int n,m;
	public static boolean dfs(int a)
	{
		if(visited[a])
			return false;
		visited[a]=true;
		
		for(int i=0;i<m;i++)
		{
			if(map[a][i])
			{
				if(job[i]==-1 ||dfs(job[i]))
				{
					employee[a]=i;
					job[i]=a;
					return true;
				}
			}
		}
		return false;
	}
	
	public static int dm(int n)
	{
		Arrays.fill(employee, -1);
		Arrays.fill(job, -1);
		
		int size=0;
		
		for(int i=0;i<n;i++)
		{
			Arrays.fill(visited, false);
			if(dfs(i))
				size++;
		}
		return size;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input=in.readLine().split(" ");
		n=Integer.parseInt(input[0]);
		m=Integer.parseInt(input[1]);
		map=new boolean[n][m];
		visited=new boolean[n];
		employee=new int[n];
		job=new int[m];
		
		
		for(int i=0;i<n;i++)
		{
			String input1[]=in.readLine().split(" ");
			int size=Integer.parseInt(input1[0]);
			for(int k=1;k<=size;k++)
			{
				int tmp=Integer.parseInt(input1[k]);
				map[i][tmp-1]=true;
			}
		}
		System.out.println(dm(n));
	}

}
