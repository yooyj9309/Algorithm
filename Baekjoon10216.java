package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon10216 {
	static int map[][] = new int[5001][5001];
	static Queue<Integer> q = new LinkedList<Integer>();

	public static int bfs(int n, int m) {

		int cnt = 0;
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= m; j++) {
				if (map[i][j] == 1)// start
				{
					map[i][j] = 0;
					q.add(i * m + j);
					while (!q.isEmpty()) {
						int y = q.peek() / m;
						int x = q.peek() % m;

						q.poll();

						if (x - 1 >= 0 && x - 1 < m)
							if (map[y][x - 1] == 1) {
								map[y][x - 1] = 0;
								q.add(y * m + x - 1);
							}
						if (x + 1 >= 0 && x + 1 < m)
							if (map[y][x + 1] == 1) {
								map[y][x + 1] = 0;
								q.add(y * m + x + 1);
							}
						if (y - 1 >= 0 && y - 1 < n)
							if (map[y - 1][x] == 1) {
								map[y - 1][x] = 0;
								q.add((y - 1) * m + x);
							}
						if (y + 1 >= 0 && y + 1 < n)
							if (map[y + 1][x] == 1) {
								map[y + 1][x] = 0;
								q.add((y + 1) * m + x);
							}
					}
					cnt++;
				}
			}
		return cnt;
	}

	public static void init(int x, int y, int r) {
		
		int tmp1 = x - r, tmp2 = y - r, tmp3 = x + r, tmp4 = y + r;

		if (x - r < 0)
			tmp1 = 0;
		if (y - r < 0)
			tmp2 = 0;
		if (x + r > 5000)
			tmp3 = 5000;
		if (y + r > 5000)
			tmp4 = 5000;

		for (int j = tmp2; j <= tmp4; j++) {
			for (int k = tmp1; k <= tmp3; k++) {
				map[j][k] = 1;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < 5001; i++)
				Arrays.fill(map[i], 0);
			int tmp = Integer.parseInt(in.readLine());
			for (int i = 0; i < tmp; i++) {
				String input[] = in.readLine().split(" ");
				int x = Integer.parseInt(input[0]);
				int y = Integer.parseInt(input[1]);
				int r = Integer.parseInt(input[2]);
				
				init(x, y, r);
			}
			System.out.println(bfs(5000, 5000));
		}
	}

}
