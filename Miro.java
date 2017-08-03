import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Miro {
	static int map[][];
	static int n, m;
	// static int min=Integer.MAX_VALUE; -> 이건 dfs 쓸때용
	static Queue<Integer> q = new LinkedList<Integer>();

	/*public static void dfs(int k, int j, int length) {

		if (k == n - 1 && j == m - 1) {
			if (min > length)
				min = length;
		}
		map[k][j] = 0;// 지나 간길 다시 지나가지 않게

		if (j - 1 >= 0 && j - 1 < m)
			if (map[k][j - 1] == 1) {
				dfs(k, j - 1, length + 1);
			}
		if (j + 1 >= 0 && j + 1 < m)
			if (map[k][j + 1] == 1) {
				dfs(k, j + 1, length + 1);
			}
		if (k - 1 >= 0 && k - 1 < n)
			if (map[k - 1][j] == 1) {
				dfs(k - 1, j, length + 1);
			}
		if (k + 1 >= 0 && k + 1 < n)
			if (map[k + 1][j] == 1) {
				dfs(k + 1, j, length + 1);
			}
		map[k][j] = 1;
	}
*/
	public static void bfs(int n, int m) {

		q.add(0);
		int visit[][] = new int[n][m];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				visit[i][j] = 0;

		visit[0][0] = 1;

		while (!q.isEmpty()) {
			int y = q.peek() / m;
			int x = q.peek() % m;

			q.poll();

			if (x - 1 >= 0 && x - 1 < m)
				if (map[y][x - 1] != 0 && visit[y][x - 1] == 0) {
					map[y][x - 1] = map[y][x] + 1;
					visit[y][x - 1] = 1;
					q.add(y * m + x - 1);
				}
			if (x + 1 >= 0 && x + 1 < m)
				if (map[y][x + 1] != 0 && visit[y][x + 1] == 0) {
					map[y][x + 1] = map[y][x] + 1;
					visit[y][x + 1] = 1;
					q.add(y * m + x + 1);
				}
			if (y - 1 >= 0 && y - 1 < n)
				if (map[y - 1][x] != 0 && visit[y - 1][x] == 0) {
					map[y - 1][x] = map[y][x] + 1;
					visit[y - 1][x] = 1;
					q.add((y - 1) * m + x);
				}
			if (y + 1 >= 0 && y + 1 < n)
				if (map[y + 1][x] != 0 && visit[y + 1][x] == 0) {
					map[y + 1][x] = map[y][x] + 1;
					visit[y + 1][x] = 1;
					q.add((y + 1) * m + x);
				}
		}
		System.out.println(map[n - 1][m - 1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		m = scan.nextInt();

		map = new int[n][m];
		String nString = "";
		for (int i = 0; i < n; i++) {
			nString = scan.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(nString.charAt(j) + "");
			}
		}
		// dfs(0,0,1);
		bfs(n, m);
	}

}
