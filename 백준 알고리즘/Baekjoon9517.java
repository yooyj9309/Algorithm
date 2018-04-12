package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9517 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int start=Integer.parseInt(in.readLine());
		int qNum=Integer.parseInt(in.readLine());
		int allTime=0;
		int result=0;
		
		for(int i=0;i<qNum;i++)
		{
			String input[]=in.readLine().split(" ");
			int time=Integer.parseInt(input[0]);
			String z=input[1];
			
			if(z.equals("T"))
			{
				if(allTime+time<=210)
				{
					allTime+=time;
					start=start%8+1;
				}
				else
				{
					result=start;
					break;
				}
			}
			else if(z.equals("P"))
			{
				if(allTime+time<=210)				
					allTime+=time;
				else
				{
					result=start;
					break;
				}
			}
			else if(z.equals("N"))
			{
				if(allTime+time<=210)
					allTime+=time;
				else
				{
					result=start;
					break;
				}
			}
			
		}
		System.out.println(result);
	}

}
