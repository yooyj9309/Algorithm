package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(in.readLine());
		long list[]=new long[n];
		String[] tmp=in.readLine().split(" ");
		
		for(int i=0;i<n;i++)
			list[i]=Long.parseLong(tmp[i]);
		Arrays.sort(list);
		
		long list1[]=new long[n];
		int m=Integer.parseInt(in.readLine());
		tmp=in.readLine().split(" ");
		
		for(int i=0;i<m;i++)
			list1[i]=Long.parseLong(tmp[i]);
		
		
		for(int i=0;i<m;i++)
		{
			int cnt=0;
			for(int j=0;j<n;j++)
			{
				if(list[j]==list1[i])
					cnt++;
			}
			System.out.print(cnt +" ");
		}
	}

}
