package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class node{
	int index,weight;
	node(int index,int weight)
	{
		this.index=index;
		this.weight=weight;
	}
}

public class Baekjoon1966 {
	public static boolean isBigger(int n1,Queue<node> q)
	{
		boolean result=false;
		Iterator<node> iter=null;
		iter=q.iterator();
		while(iter.hasNext())
		{
			if(iter.next().weight>n1)
			{
				result=true;
				break;
			}
		}
		return result;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(in.readLine());
		for(int i=0;i<testCase;i++)
		{
			String tmp[] = in.readLine().split(" ");

			int th = Integer.parseInt(tmp[1]);
			
			Queue<node> q=new LinkedList<node>();
			
			String weightText[]=in.readLine().split(" ");
			
			for(int j=0;j<weightText.length;j++)
				q.add(new node(j,Integer.parseInt(weightText[j])));
			
			int cnt=0;
			
			while(!q.isEmpty())
			{	
				node temp=q.poll();
				
				if(isBigger(temp.weight,q))
				{
					q.add(temp);
				}
				else
				{
					cnt++;
					if(temp.index==th)
						break;
				}
			}
			System.out.println(cnt);
		}
		
	}

}
