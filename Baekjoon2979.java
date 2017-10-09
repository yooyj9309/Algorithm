package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2979 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input=in.readLine().split(" ");
		int num1=Integer.parseInt(input[0]);
		int num2=Integer.parseInt(input[1]);
		int num3=Integer.parseInt(input[2]);
		
		int arr[]=new int[101];
		Arrays.fill(arr, 0);
		for(int i=0;i<3;i++)
		{
			String tmp[]=in.readLine().split(" ");
			int n1=Integer.parseInt(tmp[0]);
			int n2=Integer.parseInt(tmp[1]);
			
			for(int j=n1;j<n2;j++)
				arr[j]+=1;
		}
		int sum=0;
		for(int j=0;j<=100;j++)
		{
			if(arr[j]==1)
				sum+=num1;
			else if(arr[j]==2)
				sum+=num2*2;
			else if(arr[j]==3)
				sum+=num3*3;
		}
		System.out.println(sum);
	}

}
