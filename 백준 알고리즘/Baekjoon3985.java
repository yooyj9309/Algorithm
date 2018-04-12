package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon3985 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(in.readLine());
		int n = Integer.parseInt(in.readLine());

		int roll[] = new int[l + 1];
		Arrays.fill(roll, 0);
		int max = 0, max1 = 0;
		int maxp = 0, maxp1 = 0;

		for (int i = 0; i < n; i++) {
			String input[] = in.readLine().split(" ");
			int n1 = Integer.parseInt(input[0]);
			int n2 = Integer.parseInt(input[1]);
			int cnt = 0;

			for (int j = n1; j <= n2; j++) {
				roll[j]++;
				if (roll[j] == 1)
					cnt++;
			}

			
			if (max1 < cnt) {
				max1 = cnt;
				maxp1 = i + 1;
			}
			if (max < n2 - n1 + 1) {
				max = n2 - n1 + 1;
				maxp = i + 1;
			}
		}
		
		System.out.println(maxp);
		System.out.println(maxp1);
	}

}
