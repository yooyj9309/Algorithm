package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Point {
	int x, y;

	public Point(int y, int x) {
		this.x = x;
		this.y = y;
	}
}

public class Baekjoon14502 {
	static int map[][] = null;
	static ArrayList<Point> pList = new ArrayList<Point>();
	static boolean visit[] = null;
	static int value[] = new int[3];
	static int n = 0, m = 0;
	static int max = 0;

	public static void dfs(int v, int len) {
		if (len == 3) {
			int ans = bfs(value);
			if (max < ans)
				max = ans;
		} else {
			for (int i = v + 1; i < pList.size(); i++) {
				if (!visit[i]) {
					visit[i] = true;
					value[len] = i;
					dfs(i, len + 1);
				}
			}
		}
		visit[v] = false;
	}

	public static int bfs(int[] value) {
		int tmpMap[][] = new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
			{
				tmpMap[i][j]=map[i][j];
			}
		Point p = null;
		for (int i = 0; i < 3; i++) {
			p = pList.get(value[i]);
			tmpMap[p.y][p.x] = 1;
		}
		Queue<Point> q = new LinkedList<Point>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmpMap[i][j] == 2) {
					q.add(new Point(i, j));
					while (!q.isEmpty()) {
						Point t = q.poll();
						if (t.x + 1 < m) {
							if (tmpMap[t.y][t.x + 1] == 0) {
								tmpMap[t.y][t.x + 1] = 2;
								q.add(new Point(t.y, t.x + 1));
							}
						}
						if (t.x - 1 >= 0) {
							if (tmpMap[t.y][t.x - 1] == 0) {
								tmpMap[t.y][t.x - 1] = 2;
								q.add(new Point(t.y, t.x - 1));
							}
						}
						if (t.y + 1 < n) {
							if (tmpMap[t.y + 1][t.x] == 0) {
								tmpMap[t.y + 1][t.x] = 2;
								q.add(new Point(t.y + 1, t.x));
							}
						}
						if (t.y - 1 >= 0) {
							if (tmpMap[t.y - 1][t.x] == 0) {
								tmpMap[t.y - 1][t.x] = 2;
								q.add(new Point(t.y - 1, t.x));
							}
						}
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmpMap[i][j] == 0)
					cnt++;
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
		pList.add(new Point(0, 0));
		int k = 1;
		for (int i = 0; i < n; i++) {
			input = in.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
				if (input[j].equals("0")) {
					pList.add(k++, new Point(i, j));
				}
			}
		}

		visit = new boolean[pList.size()];
		dfs(0, 0);
		System.out.println(max);
	}

}
