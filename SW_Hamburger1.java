package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Combi {
	int x;
	int y;

	public Combi(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class SW_Hamburger1 {
	static boolean visit[] = null;
	static int n = 0;
	static int m = 0;
	static ArrayList<Combi> list = null;
	static int cnt = 1;

	public static void dfs(int v, int len) {
		if (isContain(v) || v == n) {
			if (isContain(v))
				cnt--;
		} else {
			for (int i = v + 1; i <= n; i++) {
				if (!visit[i]) {
					visit[i] = true;
					cnt++;
					dfs(i, len + 1);
				}
			}
		}
		visit[v] = false;
	}

	public static boolean isContain(int v) {
		boolean val = false;
		for (int i = 1; i <= n; i++) {
			if (visit[i]) {
				for (Combi c : list) {
					if ((c.x == v && c.y == i) || (c.x == i && c.y == v)) {
						val = true;
						break;
					}
				}
				if (val)
					break;
			}
		}
		return val;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		for (int i = 1; i <= tc; i++) {
			System.out.print("#" + i + " ");
			String input[] = in.readLine().split(" ");
			n = Integer.parseInt(input[0]);// 재료수
			m = Integer.parseInt(input[1]);// 조합수
			visit = new boolean[n + 1];
			list = new ArrayList<Combi>();
			for (int j = 0; j < m; j++) {
				input = in.readLine().split(" ");
				list.add(new Combi(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
			}
			dfs(0, 0);

			System.out.println(cnt);
			list.clear();
			cnt = 1;
		}
	}

}
