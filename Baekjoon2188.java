package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2188 {
	static boolean map[][];
	static boolean visited[];
	static int aM[],bM[];
	static int n;
	
	public static boolean dfs(int a)
	{
		if(visited[a])
			return false;
		visited[a]=true;
		
		for(int i=0;i<n;i++)
		{
			if(map[a][i])
			{
				if(bM[i]==-1||dfs(bM[i]))//이 dfs함수를 통해서 겹치는 경우 다른 노드들와 연결 상태를 보게 해준다.
				{
					aM[a]=i;
					bM[i]=a;
					return true;
				}
			}
		}
		return false;
	}
	public static int bipartiteMatch()
	{
	    Arrays.fill(aM, -1);
	    Arrays.fill(bM, -1);
	    int size = 0;
	 
	    for (int start = 0; start < n; start++)
	    {
	        Arrays.fill(visited, false);
	 
	        if (dfs(start))
	            size++;
	    }
	 
	    return size;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input[]=in.readLine().split(" ");
		n=Integer.parseInt(input[0]);
		int m=Integer.parseInt(input[1]);
		map=new boolean[n][m];
		visited=new boolean[n];
		aM=new int[n];
		bM=new int[m];
		
		for(int i=0;i<n;i++)
		{
			String input1[]=in.readLine().split(" ");
			int tmp=Integer.parseInt(input1[0]);
			for(int k=1;k<=tmp;k++)
			{
				int tmp2=Integer.parseInt(input1[k]);
				map[i][tmp2-1]=true;
			}
		}
		System.out.println(bipartiteMatch());
	}

}
