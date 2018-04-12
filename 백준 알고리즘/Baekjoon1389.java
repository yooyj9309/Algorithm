package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Place {
	int data;
	int depth;

	public Place(int data, int depth) {
		this.data = data;
		this.depth = depth;
	}
}

public class Baekjoon1389 {
	static int n, m;
	static int map[][] = null;
	static boolean map2[][] = null;
	static boolean map1[][] = null;
	static boolean visit[] = null;
	static int val[][] = null;
	static int cnt = 0;

	static Queue<Place> q = new LinkedList<Place>();

	public static void init() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map2[i][j] = map1[i][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input[] = in.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		map = new int[n + 1][n + 1];
		map1 = new boolean[n + 1][n + 1];
		map2 = new boolean[n + 1][n + 1];
		val = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(val[i], Integer.MAX_VALUE);
		}

		for (int i = 1; i <= m; i++) {
			input = in.readLine().split(" ");
			int y = Integer.parseInt(input[0]);
			int x = Integer.parseInt(input[1]);

			map[y][x] = 1;
			map[x][y] = 1;

			map1[y][x] = true;
			map1[x][y] = true;
		}
		for (int i = 1; i <= n; i++) {
			q.add(new Place(i, 1));
			init();
			while (!q.isEmpty()) {
				Place s = q.poll();
				for (int j = 1; j <= n; j++) {
					if (map[s.data][j] == 1 && map2[s.data][j]) {
						map2[s.data][j] = false;
						map2[j][s.data] = false;
						if (val[i][j] > s.depth)
							val[i][j] = s.depth;
						q.add(new Place(j, s.depth + 1));

					}
				}
			}
		}

		int sum[] = new int[n + 1];
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				if (a == b)
					continue;
				sum[a] += val[a][b];
			}
		}

		int min = Integer.MAX_VALUE;
		int idx = 0;
		for (int i = 1; i <= n; i++) {
			if (sum[i] < min) {
				min = sum[i];
				idx = i;
			}
		}
		System.out.println(idx);
	}

}
