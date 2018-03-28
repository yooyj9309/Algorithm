package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon3048 {
	public static String reverseString(String s) {
	      return (new StringBuffer(s)).reverse().toString();
	   }
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input[]=in.readLine().split(" ");
		int n1=Integer.parseInt(input[0]);
		int n2=Integer.parseInt(input[1]);
		
		String aList=reverseString(in.readLine());
		String bList=in.readLine();
		
		int t=Integer.parseInt(in.readLine());
		
		
		
	}

}
