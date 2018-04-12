package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW3750 {
	static String answer="";
	public static void call(String str)
	{
		if(str.length()==1)
		{
			answer=str;
			return ;
		}
		int sum=0;
		for(int i=0;i<str.length();i++)
		{
			sum+=Integer.parseInt(str.substring(i, i+1));
		}
		call(sum+"");
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		for (int num = 1; num <= tc; num++) {
			String str=in.readLine();
			call(str);
			System.out.println("#"+num+" "+answer);
		}
	}

}
