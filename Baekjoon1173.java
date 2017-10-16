package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1173 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input[] = in.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int m1 = Integer.parseInt(input[2]);
		int t = Integer.parseInt(input[3]);
		int r = Integer.parseInt(input[4]);

		int mac = m;
		int time = 0;

		if (mac + t > m1) {
			time = -1;
		} else {
			while (n > 0) {

				if (mac + t <= m1) {
					mac += t;
					n--;
					time++;
				} else {
					if (mac - r <= m)
						mac = m;
					else
						mac -= r;
					time++;
				}
			}
		}
		System.out.println(time);
	}

}
