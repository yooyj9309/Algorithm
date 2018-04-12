package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1932 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		int d[] = new int[num];
		Arrays.fill(d, 0);
		d[0] = Integer.parseInt(in.readLine().split(" ")[0]);
		
		if (num == 1)
			System.out.println(d[0]);
		else {
			for (int i = 0; i < num-1; i++) {
				String input[] = in.readLine().split(" ");
				int arr[] = new int[input.length];
				int size = input.length - 1;

				for (int tmp = 0; tmp < input.length; tmp++)
					arr[tmp] = Integer.parseInt(input[tmp]);
				
				d[size] = d[size - 1] + arr[size];

				for (int j = input.length - 2; j > 0; j--) 
					d[j] = Math.max(d[j], d[j - 1]) + arr[j];
	
				d[0]=d[0]+arr[0];
			}
			Arrays.sort(d);
			System.out.println(d[num-1]);
		}
		
	}

}
