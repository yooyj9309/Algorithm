package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon14888 {
	static int n=0;
	static boolean visit[]=null;
	static int value[]=null;
	static int numList[]=null;
	static String operList[]=null;
	static int min=1000000000;
	static int max=-1000000000;
	public static void dfs(int v,int len)
	{
		if(len==n-1)
		{
			solve();
		}
		else
		{
			for(int i=1;i<n;i++)
			{
				if(!visit[i])
				{
					
					visit[i]=true;
					value[len+1]=i;
					dfs(i,len+1);
				}
			}
		}
		visit[v]=false;
	}
	public static void solve()
	{
		int num=numList[0];
		for(int i=1;i<n;i++)
		{
			switch(operList[value[i]])
			{
			case "+":
				num+=numList[i];
				break;
			case "-":
				num-=numList[i];
				break;
			case "*":
				num*=numList[i];
				break;
			case "/":
				num/=numList[i];
				break;
			}
		}
		if(max<num)
			max=num;
		if(min>num)
			min=num;
	
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(in.readLine());
		String input[]=in.readLine().split(" ");
		visit=new boolean[n+1];
		value=new int[n+1];
		numList=new int[n];
		operList=new String[n];
		for(int i=0;i<n;i++)
		{
			numList[i]=Integer.parseInt(input[i]);	
		}
		input=in.readLine().split(" ");
		int k=1;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<Integer.parseInt(input[i]);j++)
			{
				switch(i){
				case 0:
					operList[k++]="+";
					break;
				case 1:
					operList[k++]="-";
					break;
				case 2:
					operList[k++]="*";
					break;
				case 3:
					operList[k++]="/";
					break;	
				}
			}
		}

		dfs(0,0);
		System.out.println(max);
		System.out.println(min);
	}

}
