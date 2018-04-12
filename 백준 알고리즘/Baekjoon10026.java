package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Po {
	int x = 0;
	int y = 0;

	public Po(int y, int x) {
		this.x = x;
		this.y = y;
	}
}

public class Baekjoon10026 {
	static char[][] map = null;
	static int n = 0;
	static char[][] tmpMap = null;
	static char[][] eMap = null;
	static Queue<Po> q = new LinkedList<Po>();
	static int x[] = { 0, 1, 0, -1 };
	static int y[] = { -1, 0, 1, 0 };

	public static void init() {
		for (int i = 0; i < n; i++) {
			for (int l = 0; l < n; l++) {
				tmpMap[i][l] = map[i][l];
			}
		}

	}

	public static void init1() {
		for (int i = 0; i < n; i++) {
			for (int l = 0; l < n; l++) {
				if (map[i][l] == 'G')
					tmpMap[i][l] = 'R';
				else
					tmpMap[i][l] = map[i][l];
			}
		}
	}

	public static int bfs(int who) {
		if (who == 0)
			init();
		else if(who==1)
			init1();
		
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tmpMap[i][j] != '0') {
					q.add(new Po(i, j));
					while (!q.isEmpty()) {
						Po t = q.poll();
						char tmp = tmpMap[t.y][t.x];
						tmpMap[t.y][t.x] = '0';
						for (int k = 0; k < 4; k++) {
							if (0 <= t.x + x[k] && t.x + x[k] < n && 0 <= t.y + y[k] && t.y + y[k] < n) {

								if (tmp == tmpMap[t.y + y[k]][t.x + x[k]] && tmp != '0') {
									q.add(new Po(t.y + y[k], t.x + x[k]));
								}

							}
						}
					}
					cnt++;
				}

			}
		}
		return cnt;
	}

	public static int bfs1(char c) {
		init1();

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (tmpMap[i][j] == c) {
					q.add(new Po(i, j));
					while (!q.isEmpty()) {
						Po t = q.poll();
						tmpMap[t.y][t.x] = '0';
						for (int k = 0; k < 4; k++) {
							if (0 <= t.x + x[k] && t.x + x[k] < n && 0 <= t.y + y[k] && t.y + y[k] < n
									&& tmpMap[t.y + y[k]][t.x + x[k]] == c) {
								q.add(new Po(t.y + y[k], t.x + x[k]));

							}
						}
					}
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
		n = Integer.parseInt(in.readLine());
		map = new char[n][n];
		tmpMap = new char[n][n];
		for (int i = 0; i < n; i++) {
			char[] tmp = in.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				map[i][j] = tmp[j];
			}

		}
		in.close();
		System.out.println(bfs(0) + " " + bfs(1));
	}
}
