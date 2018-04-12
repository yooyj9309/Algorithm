package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2193 {
//피보나치랑 똑같음. 90까지라 꽤 큰숫자가 나옴 그래서 long으로 해줘야함
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		
		if(num<2)
			System.out.println(1);
		else
		{
			long arr[]=new long[num+1];
			arr[1]=1;
			arr[2]=1;
			for(int i=3;i<=num;i++)
				arr[i]=arr[i-1]+arr[i-2];
			
			System.out.println(arr[num]);
		}
	}

}
