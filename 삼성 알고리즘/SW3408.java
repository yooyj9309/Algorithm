package SamsungExpert;

import java.util.Scanner;

public class SW3408 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int num = 1; num <= tc; num++) {
			long n=sc.nextLong();
			long s1=(n*(n+1))/2;
			long s2=n*n;
			long s3=n*n+n;
			
			System.out.println("#"+num+" "+s1+" "+s2+" "+(s3));
		}
	}

}
