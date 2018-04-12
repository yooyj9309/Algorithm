package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1120 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int min=100000;
		String[] str=in.readLine().split(" ");
		for(int i=0;i<str[1].length()-str[0].length()+1;i++)
		{
			String tmp=str[1].substring(i, i+str[0].length());
			int cnt=0;
			for(int j=0;j<str[0].length();j++)
			{
				if(!tmp.substring(j, j+1).equalsIgnoreCase(str[0].substring(j, j+1)))
				{
					cnt++;
				}
			}
			if(cnt<min)
				min=cnt;
		}
		System.out.println(min);
	}

}
