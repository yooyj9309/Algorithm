package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1547 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(in.readLine());
		int arr[]=new int[4];
		Arrays.fill(arr, 0);
		arr[1]=1;
		
		for(int i=1;i<=testCase;i++)
		{
			String[] input=in.readLine().split(" ");
			int num1=Integer.parseInt(input[0]);
			int num2=Integer.parseInt(input[1]);
			int tmp=0;
			
			tmp=arr[num1];
			arr[num1]=arr[num2];
			arr[num2]=tmp;
		}
		for(int i=1;i<=3;i++)
		{
			if(arr[i]==1)
			{
				System.out.println(i);
				break;
			}
		}
	}

}
