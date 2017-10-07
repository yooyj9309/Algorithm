package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2597 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		int arr[]=new int[num];
		int d[]=new int[num];
		

		for(int i=0;i<num;i++)
			arr[i]=Integer.parseInt(in.readLine());
		
		d[0]=arr[0];
		
		d[1]=Math.max(d[0]+arr[1],arr[1]);//
		d[2]=Math.max(d[0]+arr[2], arr[1]+arr[2]);
		
		for(int i=3;i<num;i++)
			d[i]=Math.max(d[i-2]+arr[i], d[i-3]+arr[i]+arr[i-1]);
		System.out.println(d[num-1]);
	}

}
