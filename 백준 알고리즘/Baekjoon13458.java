package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon13458 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(in.readLine());
		String input[]=in.readLine().split(" ");
		long m[]=new long[n];
		for(int i=0;i<n;i++)
		{
			m[i]=Integer.parseInt(input[i]);
		}
		input=in.readLine().split(" ");
		long b=Integer.parseInt(input[0]);
		long c=Integer.parseInt(input[1]);
		long sum=n;
		for(int i=0;i<n;i++)
		{
			m[i]-=b;
			if(m[i]>0)sum+=m[i]/c;
			if(m[i]%c>0)sum++;
		}
		System.out.println(sum);
	}

}
