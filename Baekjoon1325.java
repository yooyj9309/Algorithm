package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1325 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input[] = in.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		Queue<Integer> q = new LinkedList<Integer>();

		ArrayList<Integer> list[] = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++)
			list[i] = new ArrayList<Integer>();
		int max = 0;
		int size = 0;
		int dp[] = new int[n + 1];
		Arrays.fill(dp, 0);
		for (int i = 0; i < m; i++) {
			String tmp[] = in.readLine().split(" ");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			list[y].add(x);
		}

		for (int i = 1; i < n + 1; i++) {
			int visit[] = new int[10001];
			Arrays.fill(visit, 0);
			q.add(i);
			int cnt = 0;
			cnt++;
			while (!q.isEmpty()) {
				int tmp = q.poll();
				for (int t : list[tmp]) {
					if (visit[t] == 0) {
						visit[t] = 1;
						q.add(t);
						cnt++;
					}
				}
			}
			if (max < cnt) {
				size = 0;
				max = cnt;
				dp[size++] = i;
			} else if (max == cnt) {
				dp[size++] = i;
			}

		}

		for (int i = 0; i < size; i++)
			System.out.print(dp[i] + " ");
	}

}
