package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2980 {

	public static boolean r(int r, int g,int t,int cycle)
	{
		int tmp=r+cycle*(r+g);
		if(tmp-2<=t&&t<=tmp)
			return true;
		else
			return false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp=in.readLine().split(" ");
		int n=Integer.parseInt(tmp[0]);
		int l=Integer.parseInt(tmp[1]);
		
		int d=0,r=0,g=0;
		int time=0;
		int distance=0;
		
		for(int i=0;i<n;i++)
		{
		  tmp=in.readLine().split(" ");
		  d=Integer.parseInt(tmp[0]);
		  r=Integer.parseInt(tmp[1]);
		  g=Integer.parseInt(tmp[2]);
		  
		  time+=d-distance;
		  distance=d;
		  
		  int red=time%(r+g);
		  if(red<=r)
			  time+=r-red;
		}
		 System.out.println(time+l-distance);
	}

}
