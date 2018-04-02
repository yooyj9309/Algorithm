package Algortihm2;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon11404 {
	final static int INF = 1000000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int map[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					map[i][j] = 0;
				else
					map[i][j]=INF;
			}
		}
		for (int num = 0; num < m; num++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			map[a-1][b-1] = Math.min(map[a-1][b-1], c);
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j]=Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
