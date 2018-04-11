package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SW3975 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(in.readLine());
		for(int num=1;num<=tc;num++)
		{
			String input[]=in.readLine().split(" ");
			double a=Double.parseDouble(input[0]);
			double b=Double.parseDouble(input[1]);
			double c=Double.parseDouble(input[2]);
			double d=Double.parseDouble(input[3]);
			
			double alice=a/b;
			double bob=c/d;
			
			if(alice==bob)
				System.out.println("#"+num+" "+"DRAW");
			else if(alice<bob)
				System.out.println("#"+num+" "+"BOB");
			else
				System.out.println("#"+num+" "+"ALICE");
		}
	}

}
