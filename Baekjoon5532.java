package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5532 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(in.readLine());
		int[] n=new int[4];
		
		for(int i=0;i<4;i++)
			n[i]=Integer.parseInt(in.readLine());
		
		int cmp1=0,cmp2=0;
		
		if(n[0]%n[2]!=0)
			cmp1=n[0]/n[2]+1;
		else
			cmp1=n[0]/n[2];
		
		if(n[1]%n[3]!=0)
			cmp2=n[1]/n[3]+1;
		else
			cmp2=n[1]/n[3];
		
		if(cmp1<cmp2)
			System.out.println(num-cmp2);
		else
			System.out.println(num-cmp1);
	}

}
