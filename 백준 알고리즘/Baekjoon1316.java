package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1316 {
	public static boolean isPossible(String s)
	{
		boolean val=true;
		char[] str=s.toCharArray();
		boolean visit[]=new boolean [26];
		for(int i=0;i<str.length;i++)
		{
			int k=str[i]-'a';
			if(!visit[k])
				visit[k]=true;
			else if(str[i]==str[i-1])
			{
				continue;
			}
			else{
				val=false;
				break;
			}
		}
		return val;
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(in.readLine());
		int cnt=0;
		for(int i=0;i<n;i++)
		{
			if(isPossible(in.readLine()))
				cnt++;
		}
		System.out.println(cnt);
	}
}
