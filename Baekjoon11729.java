package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11729 {

	public static void solve(int n,int x,int y)
	{
		if(n==0) return;
		solve(n-1,x,6-x-y);
		System.out.println(x+ " " + y);
		solve(n-1,6-x-y,y);
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(in.readLine());
		System.out.println((1<<n)-1);
		solve(n,1,3);
	}

}
