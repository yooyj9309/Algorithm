package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2573 {
	static int map[][] = null;
	static boolean map1[][] = null;
	static int temp[][] = null;
	static int n, m;
	static int[] ax = { 0, 1, 0, -1 };
	static int[] ay = { 1, 0, -1, 0 };

	public static void dfs(int x, int y) {
		map1[y][x] = true;
		for (int k = 0; k < 4; k++) {
			int nx = x + ax[k];
			int ny = y + ay[k];

			if (0 <= nx && nx < m && 0 <= ny && ny < n) {
				if (!map1[ny][nx] && map[ny][nx] > 0) {
					dfs(nx, ny);
				}
			}
		}
	}

	public static int getComponent() {
		int iceLand = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!map1[i][j] && map[i][j] > 0) {
					iceLand++;
					dfs(j, i);
				}
			}
		}
		return iceLand;
	}

	public static int nextYear(int y, int x) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nx = ax[i] + x;
			int ny = ay[i] + y;

			if (0 <= ny && ny < n && 0 <= nx && nx < m) {
				if (map[ny][nx] <= 0 && map[y][x] > 0) {
					++cnt;
				}
			}
		}
		return cnt;
	}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input[] = in.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		map = new int[n][m];
		temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			input = in.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		int y = 0;
		int tmp = 0;
		int ans = 0;
		map1 = new boolean[n][m];
		while ((tmp = getComponent()) < 2) {
			if (tmp == 0) {
				ans = 0;
				break;
			}
			ans++;
			map1 = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] > 0) {
						temp[i][j] = nextYear(i, j);
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] -= temp[i][j];
				}
			}
		}
		System.out.println(ans);
	}

}
