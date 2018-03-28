package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Baekjoon2583 {
	static int map[][] = null;

	public static void mapInit(int x, int y, int x1, int y1) {
		for (int i = y; i < y1; i++)
			for (int j = x; j < x1; j++)
				map[i][j] = 0;

	}

	public static void show(int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input[] = in.readLine().split(" ");
		Queue<Point> q = new LinkedList<Point>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);

		map = new int[n][m];
		for (int i = 0; i < n; i++)
			Arrays.fill(map[i], 1);

		for (int i = 0; i < k; i++) {
			input = in.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			int x1 = Integer.parseInt(input[2]);
			int y1 = Integer.parseInt(input[3]);

			mapInit(x, y, x1, y1);
		}

		int count = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
					Point p = new Point(j, i);
					q.add(p);
					int w = 1;
					while (!q.isEmpty()) {
						Point t = q.poll();
						map[t.y][t.x] = 0;
						if (t.x + 1 < m) {
							if (map[t.y][t.x + 1] != 0) {
								q.add(new Point(t.x + 1, t.y));
								map[t.y][t.x + 1] = 0;
								w++;
							}
						}
						if (t.x - 1 >= 0) {
							if (map[t.y][t.x - 1] != 0) {
								q.add(new Point(t.x - 1, t.y));
								map[t.y][t.x - 1] = 0;
								w++;
							}
						}
						if (t.y + 1 < n) {
							if (map[t.y + 1][t.x] != 0) {
								q.add(new Point(t.x, t.y + 1));
								map[t.y + 1][t.x] = 0;
								w++;
							}
						}
						if (t.y - 1 >= 0) {
							if (map[t.y - 1][t.x] != 0) {
								q.add(new Point(t.x, t.y - 1));
								map[t.y - 1][t.x] = 0;
								w++;
							}
						}
					}
					list.add(w);
					count++;
				}
			}
		System.out.println(count);
		Collections.sort(list);
		for (int a : list)
			System.out.print(a + " ");
	}

}
