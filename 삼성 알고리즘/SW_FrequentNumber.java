package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SW_FrequentNumber {

	public static int getMax(int[] score)
	{
		int max=0;
		int index=0;
		for(int i=0;i<score.length;i++)
		{
			if(max<=score[i]){
				max=score[i];
				index=i;
			}
		}
		return index;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(in.readLine());
		
		for(int num=0;num<tc;num++)
		{
			int score[]=new int[101];
			int caseNum=Integer.parseInt(in.readLine());
			String input[]=in.readLine().split(" ");
			
			for(int i=0;i<input.length;i++)
				score[Integer.parseInt(input[i])]++;
			
			int max=getMax(score);
			System.out.println("#"+caseNum+" "+max);
		}
	}

}
