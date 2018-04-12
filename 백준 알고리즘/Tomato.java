import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {

	public static void main(String[] args) {
		int n, m,result=0;
		int visit[][];
		Queue<Integer> q = new LinkedList<Integer>();

		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();// 가로 길이
		m = scan.nextInt();// 세로 길이

		visit = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				visit[i][j] = scan.nextInt();
				if (visit[i][j] == 1)
					q.add(i * n + j);
			}
		}

		while (!q.isEmpty()) {
			int v = q.poll();
			int y = v / n;
			int x = v % n;

			if (x - 1 >= 0 && x - 1 < n) {
				if (visit[y][x - 1] == 0 && visit[y][x - 1] != -1) {
					visit[y][x - 1] = visit[y][x] + 1;
					q.add(y * n + (x - 1));
				}
			}
			if (x + 1 >= 0 && x + 1 < n) {
				if (visit[y][x + 1] == 0 && visit[y][x + 1] != -1) {
					visit[y][x + 1] = visit[y][x] + 1;
					q.add(y * n + (x + 1));
				}
			}
			if (y - 1 >= 0 && y - 1 < m) {
				if (visit[y - 1][x] == 0 && visit[y - 1][x] != -1) {
					visit[y - 1][x] = visit[y][x] + 1;
					q.add((y - 1) * n + x);
				}
			}
			if (y + 1 >= 0 && y + 1 < m) {
				if (visit[y + 1][x] == 0 && visit[y + 1][x] != -1) {
					visit[y + 1][x] = visit[y][x] + 1;
					q.add((y + 1) * n + x);
				}
			}
		}
		int max=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(max<visit[i][j])
					max=visit[i][j];
				if(visit[i][j]==0)
					result=-1;
				System.out.print(visit[i][j] +" ");
			}
			System.out.println();
		}
		if(result==-1)
			System.out.println(-1);
		else
			System.out.println(max-1);
	}
}


