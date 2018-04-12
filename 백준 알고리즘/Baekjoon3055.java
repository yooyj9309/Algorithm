package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon3055 {
	static int[][] visit;
	static Queue<Integer> q =new LinkedList<Integer>();
	static int start=0,end=0;
	
	public static void bfs(int n, int m,int start,int end)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(visit[i][j]==2)
				{
					visit[i][j]=0;
					q.add(i*m+j);
					while(!q.isEmpty())
					{
						int y=q.peek()/m;
						int x=q.peek()%m;
						
						q.poll();
						
					}
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] sizes=in.readLine().split(" ");
	
		int col=Integer.parseInt(sizes[0]);
		int row=Integer.parseInt(sizes[1]);
		
		visit= new int[col][row];

		for(int i=0;i<col;i++)
		{
			String[] tmp= in.readLine().split(" ");
			for(int j=0;j<row;j++)
			{
				if(tmp[j].equalsIgnoreCase("."))
					visit[i][j]=1;
				else if(tmp[j].equalsIgnoreCase("S"))
				{
					visit[i][j]=3;
					start=i*row+j;
				}
				else if(tmp[j].equalsIgnoreCase("*"))
					visit[i][j]=2;
				else if(tmp[j].equalsIgnoreCase("D")){
					visit[i][j]=4;
					end=i*row+j;
				}
				else if(tmp[i].equalsIgnoreCase("X"))
					visit[i][j]=0;
			}
		}
		
		
	}

}
