package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon6603 {
	static int list[] = null;
	static boolean visit[] = null;
	static int n = -1;

	public static void dfs(int v, int len) {
		if (len == 6) {
			show();
		} else {
			for (int i = v + 1; i <= n; i++) {
				if (!visit[i]) {
					visit[i] = true;
					dfs(i, len + 1);
				}
			}
		}
		visit[v] = false;
	}

	public static void show() {
		for (int i = 1; i <= n; i++) {
			if (visit[i])
				System.out.print(list[i]+ " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (n != 0) {
			String input[] = in.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			if(n==0)
				break;
			list = new int[n + 1];
			visit = new boolean[n + 1];
			for (int i = 1; i <= n; i++)
				list[i] = Integer.parseInt(input[i]);
			dfs(0, 0);
			System.out.println();
		}
	}

}
