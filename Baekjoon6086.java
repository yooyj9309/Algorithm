package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon6086 {
	static int maxVal = 52;

	public static int Ctoi(String t) {

		if (t.charAt(0) <= 'Z') {
			return t.charAt(0)-'A';
		}
		else
			return t.charAt(0)-'a'+26;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		ArrayList<Integer> adj[] = new ArrayList[maxVal];
		for (int i = 0; i < maxVal; i++)
			adj[i] = new ArrayList<Integer>();
		int c[][] = new int[maxVal][maxVal];
		int f[][] = new int[maxVal][maxVal];
		Queue<Integer> q;
		for (int i = 0; i < maxVal; i++) {
			for (int j = 0; j < maxVal; j++) {
				c[i][j] = 0;
				f[i][j] = 0;
			}
		}
		for (int i = 0; i < num; i++) {
			String input[] = in.readLine().split(" ");
			int s = Ctoi(input[0]);
			int e = Ctoi(input[1]);

			adj[s].add(e);
			adj[e].add(s);
			c[s][e] += Integer.parseInt(input[2]);

		}

		int S = 0, E = 25;
		int total = 0;
		while (true) {
			int prev[] = new int[maxVal];
			Arrays.fill(prev, -1);
			q = new LinkedList<Integer>();
			q.add(S);
			while (!q.isEmpty()) {
				int now = q.poll();
				for (int i = 0; i < adj[now].size(); i++) {
					int next = adj[now].get(i);
					if (c[now][next] - f[now][next] > 0 && prev[next] == -1) {
						prev[next] = now;
						q.add(next);
						if (next == E)
							break;
					}
				}
			}
			if (prev[E] == -1)
				break;

			int flow = Integer.MAX_VALUE;

			for (int i = E; i != S; i = prev[i])
				flow = Math.min(flow, c[prev[i]][i] - f[prev[i]][i]);
			for (int i = E; i != S; i = prev[i]) {
				f[prev[i]][i] += flow;
				f[i][prev[i]] -= flow;
			}
			total += flow;
		}
		System.out.println(total);
	}

}
