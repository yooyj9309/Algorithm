package SamsungExpert;

import java.util.Scanner;

public class SW3431 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int num = 1; num <= tc; num++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			if(c<a)
				System.out.println("#"+num+" "+(a-c));
			else if(a<=c&&c<=b)
				System.out.println("#"+num+" "+0);
			else if(b<c)
				System.out.println("#"+num+" "+(-1));
		}
	}

}
