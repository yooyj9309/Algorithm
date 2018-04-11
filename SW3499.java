package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());

		for (int num = 1; num <= tc; num++) {
			int standard = 0;
			int n = Integer.parseInt(in.readLine());

			if (n % 2 == 0)
				standard = n / 2;
			else
				standard = n / 2 + 1;

			String arr1[] = new String[standard];
			String arr2[] = new String[n - standard];

			String input[] = in.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				if (i < standard) {
					arr1[i] = input[i];
				} else {
					arr2[i - standard] = input[i];
				}
			}
			int i=0;
			String ans="";
			while(i<=n/2)
			{
				if(i<arr1.length)
					ans+=arr1[i]+" ";
				if(i<arr2.length)
					ans+=arr2[i]+" ";
				
				i++;
			}
			System.out.println("#"+num+" "+ans);
		}
	}

}
