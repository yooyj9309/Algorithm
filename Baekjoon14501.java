package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon14501 {
	static int n = 0;
	static int tList[] = null;
	static int pList[] = null;
	static boolean visit[] = null;
	static int value[] = null;
	static int max = 0;

	public static void dfs(int i, int sum) {
		if (i == n + 1) {
			max = Math.max(max, sum);
			return;
		}
		if (i + tList[i] <= n + 1)
			dfs(i + tList[i], sum + pList[i]);
		if (i + 1 <= n + 1)
			dfs(i + 1, sum);

	}

	public static int getBenefit() {
		int num = 0;
		for (int i = 1; i <= n; i++) {
			if (visit[i])
				num += pList[i];
		}
		return num;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		tList = new int[n + 100];
		pList = new int[n + 1];
		visit = new boolean[n + 1];
		value = new int[n + 1];
		Arrays.fill(visit, false);

		for (int i = 1; i <= n; i++) {
			String input[] = in.readLine().split(" ");
			tList[i] = Integer.parseInt(input[0]);
			pList[i] = Integer.parseInt(input[1]);
		}
		dfs(1, 0);
		System.out.println(max);
	}

}
