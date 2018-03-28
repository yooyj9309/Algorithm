package Algortihm2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NetworkFlow {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int S=0,E=1;
		ArrayList<Integer> adj[]=new ArrayList[501];
		int[][] c= new int[501][501];
		int[][] f =new int[501][501];
		Queue<Integer> q;
		//그래프 만들기
		
		
		while(true)
		{
			int prev[]=new int[501];
			Arrays.fill(prev, -1);
			q=new LinkedList<Integer>();
			q.add(S);
			int total=0;
			while(!q.isEmpty())
			{
				int now=q.poll();
				if(now==E)
					break;
				for(int i=0;i<adj[now].size();i++)
				{
					int next=adj[now].get(i);
					if(prev[next]==-1&&c[now][next]-f[now][next]>0)
					{
						q.add(next);
						prev[next]=now;
					}
				}
			}
			if(prev[E]==-1) break;
			
			int flow=12345567;
			for(int i=E;i!=S;i=prev[i])
				flow=Math.min(flow,c[prev[i]][i]-f[prev[i]][i]);
			for(int i=E;i!=S;i=prev[i])
			{
				f[prev[i]][i]+=flow;
				f[i][prev[i]]-=flow;
			}
			total+=flow;
		}
	}

}
