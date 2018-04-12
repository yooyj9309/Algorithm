package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon9095 {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(in.readLine());
		
		int d[]=new int[12];
		Arrays.fill(d, 0);
		d[0]=1;
		
		for(int i=1;i<12;i++)
		{
			if(i-1>=0)
				d[i]+=d[i-1];
			if(i-2>=0)
				d[i]+=d[i-2];
			if(i-3>=0)
				d[i]+=d[i-3];
		}
		for(int i=0;i<num;i++)
		{
			int tmp=Integer.parseInt(in.readLine());
			System.out.println(d[tmp]);
		}
	}

}
