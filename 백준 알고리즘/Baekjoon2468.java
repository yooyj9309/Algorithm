package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2468 {

	public static int map[][] = null;
	public static int n = 0;

	public static int bfs(int k) {
		Queue<Point> q = new LinkedList<Point>();
		boolean bmap[][] = getBooleanMap(k);
		int count=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (bmap[i][j]) {
					Point p = new Point(j, i);
					q.add(p);
					while (!q.isEmpty()) {
						Point t = q.poll();
						if (t.x + 1 < n) {
							if (bmap[t.y][t.x + 1]) {
								q.add(new Point(t.x + 1, t.y));
								bmap[t.y][t.x + 1] = false;
							}
						}
						if (t.y + 1 < n) {
							if (bmap[t.y+1][t.x]) {
								q.add(new Point(t.x, t.y+1));
								bmap[t.y+1][t.x] = false;
							}
						}
						if (t.y - 1 >= 0) {
							if (bmap[t.y-1][t.x]) {
								q.add(new Point(t.x, t.y-1));
								bmap[t.y-1][t.x ] = false;
							}
						}
						if (t.x - 1 >= 0) {
							if (bmap[t.y][t.x - 1]) {
								q.add(new Point(t.x - 1, t.y));
								bmap[t.y][t.x - 1] = false;
							}
						}
					}
					count++;
				}
			}
		}
		return count;
	}

	public static boolean[][] getBooleanMap(int k) {
		boolean bmap[][] = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] > k)
					bmap[i][j] = true;
			}
		}
		return bmap;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String input[] = in.readLine().split(" ");
			for (int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(input[j]);
		}
		int max=0;
		for(int i=0;i<=100;i++)
		{
			max=Math.max(max, bfs(i));
		}
		System.out.println(max);
	}

}
