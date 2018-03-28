package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon14500 {
	static int map[][] = null;
	static boolean visit[][] = null;
	static int max = 0;
	static int[] a = { 0, -1, 0, 1 };
	static int[] b = { -1, 0, 1, 0 };
	static int n = 0;
	static int m = 0;

	public static void dfs(int len, int x, int y, int sum) {
		int aX,aY;
		if (len == 3) {
			sum+=map[y][x];
			if (max < sum)
				max = sum;
			//System.out.println(sum);
			return;
		}
		visit[y][x] = true;
		for (int i = 0; i < 4; i++) {
			aX = x + a[i];
			aY = y + b[i];

			if (0 <= aX && aX < m && 0 <= aY && aY < n && !visit[aY][aX])
				dfs(len + 1, aX, aY, sum + map[y][x]);
		}

		visit[y][x] = false;
	}

	public static void cross(int x, int y) {
		int count = 0;
		boolean t[] = new boolean[4];
		for (int i = 0; i < 4; i++) {
			int aX = x + a[i];
			int aY = y + b[i];

			if (0 <= aX && aX < m && 0 <= aY && aY < n) {
				count++;
				t[i] = true;
			}
		}
		int sum = map[y][x];
		int min = 1000;
		if (count == 3) {
			for (int i = 0; i < 4; i++) {
				if (t[i]) {
					int aX = x + a[i];
					int aY = y + b[i];

					sum += map[aY][aX];
				}
			}
		} else if (count == 4) {
			for (int i = 0; i < 4; i++) {
				int aX = x + a[i];
				int aY = y + b[i];

				if (min > map[aY][aX])
					min = map[aY][aX];
				sum += map[aY][aX];
			}
			sum -= min;
		}
	
		if (max < sum)
			max = sum;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input[] = in.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			input = in.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dfs(0, j, i, 0);
				cross(j, i);
			}
		}
		System.out.println(max);
	}

}
