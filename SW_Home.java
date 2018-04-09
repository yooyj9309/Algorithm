package SamsungExpert;

import java.util.Scanner;

public class SW_Home {
	public static int n = 0;
	public static int map[][] = null;
	public static final int padding = 20;
	public static int max = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int num = 1; num <= tc; num++) {
			n = sc.nextInt();
			int m = sc.nextInt();

			map = new int[n + padding * 2+1][n + padding * 2+1];
			for (int i = padding; i < padding + n; i++) {
				for (int j = padding; j < padding + n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = padding; i < padding + n; i++) {
				for (int j = padding; j < padding + n; j++) {
					for (int k = 1; k <= n+1; k++) {
						int home = 0;
						home = search(i, j, k);
						int val = m * home - cost(k);
						if (val >= 0){
							max = Math.max(max, home);
						}
					}
				}
			}
			System.out.println("#" + num + " " + max);
			max = 0;

		}

	}

	public static int search(int i, int j, int k) {
		int home = 0;

		for (int y = i - (k - 1); y <= i + (k - 1); y++) {
			for (int x = j - (k - 1); x <= j + (k - 1); x++) {
				if (map[y][x] == 1)
					home++;
			}
		}

		for (int y = 0; y < k - 1; y++) {
			for (int x = 0; x < k - 1 - y; x++) {
				if (map[i - (k - 1) + y][j - (k - 1) + x] == 1)
					--home;
				if (map[i - (k - 1) + y][j + (k - 1) - x] == 1)
					--home;
				if (map[i + (k - 1) - y][j - (k - 1) + x] == 1)
					--home;
				if (map[i + (k - 1) - y][j + (k - 1) - x] == 1)
					--home;
			}
		}

		return home;
	}

	public static int cost(int k) {
		return (k * k) + ((k - 1) * (k - 1));
	}
}
