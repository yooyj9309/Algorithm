package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon7562 {
	static int map[][] = null;
	static int size = 0;
	static Queue<Point> q = new LinkedList<Point>();
	static int count = 0;


	public static void bfs(Point start, Point end) {
		q.clear();
		q.add(start);

		map[start.y][start.x] = 1;
		while (!q.isEmpty()) {
			Point t = q.poll();
			if (t.x == end.x && t.y == end.y) {
				System.out.println(map[end.y][end.x] - 1);
				break;
			}
			if (t.x + 1 < size && t.y + 2 < size) {
				if (map[t.y + 2][t.x + 1] == 0) {
					q.add(new Point(t.x + 1, t.y + 2));
					map[t.y + 2][t.x + 1] = map[t.y][t.x] + 1;
				}
			}
			if (t.x + 2 < size && t.y + 1 < size) {
				if (map[t.y + 1][t.x + 2] == 0) {
					q.add(new Point(t.x + 2, t.y + 1));
					map[t.y + 1][t.x + 2] = map[t.y][t.x] + 1;
				}
			}
			if (t.x + 2 < size && t.y - 1 >= 0) {
				if (map[t.y - 1][t.x + 2] == 0) {
					q.add(new Point(t.x + 2, t.y - 1));
					map[t.y - 1][t.x + 2] = map[t.y][t.x] + 1;
				}
			}
			if (t.x + 1 < size && t.y - 2 >= 0) {
				if (map[t.y - 2][t.x + 1] == 0) {
					q.add(new Point(t.x + 1, t.y - 2));
					map[t.y - 2][t.x + 1] = map[t.y][t.x] + 1;
				}
			}
			if (t.x - 1 >= 0 && t.y - 2 >= 0) {
				if (map[t.y - 2][t.x - 1] == 0) {
					q.add(new Point(t.x - 1, t.y - 2));
					map[t.y - 2][t.x - 1] = map[t.y][t.x] + 1;
				}
			}
			if (t.x - 2 >= 0 && t.y - 1 >= 0) {
				if (map[t.y - 1][t.x - 2] == 0) {
					q.add(new Point(t.x - 2, t.y - 1));
					map[t.y - 1][t.x - 2] = map[t.y][t.x] + 1;
				}
			}
			if (t.x - 2 >= 0 && t.y + 1 < size) {
				if (map[t.y + 1][t.x - 2] == 0) {
					q.add(new Point(t.x - 2, t.y + 1));
					map[t.y + 1][t.x - 2] = map[t.y][t.x] + 1;
				}
			}
			if (t.x - 1 >= 0 && t.y + 2 < size) {
				if (map[t.y + 2][t.x - 1] == 0) {
					q.add(new Point(t.x - 1, t.y + 2));
					map[t.y + 2][t.x - 1] = map[t.y][t.x] + 1;
				}
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			size = Integer.parseInt(in.readLine());
			map = new int[size][size];
			for (int k = 0; k < size; k++)
				Arrays.fill(map[k], 0);
			
			String input[] = in.readLine().split(" ");

			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			Point start = new Point(x, y);

			String input1[] = in.readLine().split(" ");
			int x1 = Integer.parseInt(input1[0]);
			int y1 = Integer.parseInt(input1[1]);
			Point end = new Point(x1, y1);

			bfs(start, end);
		}
	}

}