package SamsungExpert;

import java.util.Scanner;

public class SW1953 {
	public static int[][] map = null;
	public static boolean[][] visit = null;
	public static boolean[][] answer = null;
	public static int[] ax = { 0, 0, -1, 1 };
	public static int[] ay = { -1, 1, 0, 0 };
	public static int n, m, l;
	public static int max = 0;

	public static int getAns() {
		int val=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(answer[i][j])
					val++;
			}
		}
		return val;
	}
	public static void dfs(int y, int x, int len, int type) {
		if (len == l) {
			answer[y][x]=true;
			return;
		}
		visit[y][x] = true;
		answer[y][x]=true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + ax[i];
			int ny = y + ay[i];

			if (0 <= nx && nx < m && 0 <= ny && ny < n) {
				if (map[ny][nx] != 0 && !visit[ny][nx]) {
					switch (type) {
					case 1:
						switch (i) {
						case 0:
							if (!(map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;
						case 1:
							if (!(map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;
						case 2:
							if (!(map[ny][nx] == 2 || map[ny][nx] == 6 || map[ny][nx] == 7))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;
						case 3:
							if (!(map[ny][nx] == 2 || map[ny][nx] == 4 || map[ny][nx] == 5))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;
						}
						break;
					case 2:
						switch (i) {
						case 0:
							if (!(map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;
						case 1:
							if (!(map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;
						}
						break;
					case 3:
						switch (i) {
						case 2:
							if (!(map[ny][nx] == 2 || map[ny][nx] == 6 || map[ny][nx] == 7))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;
						case 3:
							if (!(map[ny][nx] == 2 || map[ny][nx] == 4 || map[ny][nx] == 5))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;
						}
						break;
					case 4:
						switch (i) {
						case 0:
							if (!(map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;
						case 3:
							if (!(map[ny][nx] == 2 || map[ny][nx] == 4 || map[ny][nx] == 5))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;
						}
						break;
					case 5:
						switch (i) {
						case 1:
							if (!(map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;

						case 3:
							if (!(map[ny][nx] == 2 || map[ny][nx] == 4 || map[ny][nx] == 5))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;
						}
						break;
					case 6:
						switch (i) {
						case 1:
							if (!(map[ny][nx] == 3 || map[ny][nx] == 5 || map[ny][nx] == 6))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;
						case 2:
							if (!(map[ny][nx] == 2 || map[ny][nx] == 6 || map[ny][nx] == 7))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;
						}
						break;
					case 7:
						switch (i) {
						case 0:
							if (!(map[ny][nx] == 3 || map[ny][nx] == 4 || map[ny][nx] == 7))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;

						case 2:
							if (!(map[ny][nx] == 2 || map[ny][nx] == 6 || map[ny][nx] == 7))
								dfs(ny, nx, len + 1, map[ny][nx]);
							break;
						}
						break;
					}
				}
			}
		}
		visit[y][x] = false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int num = 1; num <= tc; num++) {
			n = sc.nextInt();
			m = sc.nextInt();
			int r = sc.nextInt();
			int c = sc.nextInt();
			l = sc.nextInt();
			
			map = new int[n][m];
			visit = new boolean[n][m];
			answer = new boolean[n][m];
			
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					map[i][j] = sc.nextInt();

			dfs(r, c, 1, map[r][c]);
			System.out.println("#"+num+" "+getAns());
		}
	}

}
