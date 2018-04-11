package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Sw4050 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		for (int num = 1; num <= tc; num++) {
			int n=Integer.parseInt(in.readLine());
			String str[]=in.readLine().split(" ");
			int[] arr=new int[n];
			ArrayList<Integer> list=new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				list.add(Integer.parseInt(str[i]));
			Collections.sort(list);
			Collections.reverse(list);
			
			long sum=0;
			for(int i=0;i<n;i++)
			{
				if((i+1)%3==0)
					continue;
				sum+=list.get(i);	
			}
			System.out.println("#"+num+" "+sum);
		}
	}

}
