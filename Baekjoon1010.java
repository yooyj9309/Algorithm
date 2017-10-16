package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1010 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		

		for(int idx=0;idx<num;idx++)
		{
			String input[]=in.readLine().split(" ");
			int n=Integer.parseInt(input[0]);
			int m=Integer.parseInt(input[1]);
		
			long d[][] = new long[n+1][m+1];
			
			for (int i = 0; i <= m; i++) 
				d[1][i] = i;

			for(int i=2;i<=n;i++)
				for(int j=i;j<=m;j++)
					for(int k=j;k>=i;k--)
						d[i][j]+=d[i-1][k-1];
			
			System.out.println(d[n][m]);
		}
	}

}
