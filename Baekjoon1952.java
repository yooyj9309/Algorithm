package Algortihm2;

import java.util.Scanner;

public class Baekjoon1952 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int r = scan.nextInt();
		int c = scan.nextInt();
		int count = 0;
		int val = 1;
		int z1 = r, z2 = c;

		while (val <= z1 * z2) {
			for (int j = 0; j < c; j++)
				val++;

			if (c >= 1 && val <= z1 * z2)
				count++;
			r--;

			for (int k = 0; k < r; k++)
				val++;

			if (r >= 1 && val <= z1 * z2)
				count++;
			c--;
		}
		System.out.println(count);

	}
}
