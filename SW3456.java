package SamsungExpert;

import java.util.Scanner;

public class SW3456 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int num = 1; num <= tc; num++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			
			int ans=0;
			
			if(a==b)
				ans=c;
			else if(a==c)
				ans=b;
			else if(b==c)
				ans=a;
			
			System.out.println("#"+num+" "+ans);
		}
	}

}
