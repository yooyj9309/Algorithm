package SamsungExpert;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class Core {
	int x;
	int y;
	// ArrayList<Integer> dirlist = new ArrayList<Integer>();

	Core(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

class Pair {
	int len;
	int dir;

	Pair(int dir, int len) {
		this.dir = dir;
		this.len = len;
	}
}

public class SW1767 {
	static int n = 0;
	static int map[][] = null;
	static int maxCount = 0;
	static int minLine = Integer.MAX_VALUE;
	static Stack<Pair> putList = new Stack<Pair>();
	static ArrayList<Core> corelist = new ArrayList<Core>();

	public static boolean canPut(int num, Core c) {
		boolean check = true;
		switch (num) {
		case 1:
			for (int i = 0; i < c.y; i++) {
				if (map[i][c.x] != 0) {
					check = false;
					break;
				}
			}
			break;
		case 2:
			for (int i = n - 1; i > c.x; i--) {
				if (map[c.y][i] != 0) {
					check = false;
					break;
				}
			}
			break;
		case 3:
			for (int i = n - 1; i > c.y; i--) {
				if (map[i][c.x] != 0) {
					check = false;
					break;
				}
			}
			break;
		case 4:
			for (int i = 0; i < c.x; i++) {
				if (map[c.y][i] != 0) {
					check = false;
					break;
				}
			}
			break;
		}
		return check;
	}

	public static void put(int num, Core c, int ans) {
		switch (num) {
		case 1:
			for (int i = 0; i < c.y; i++) {
				map[i][c.x] = ans;
			}
			break;
		case 2:
			for (int i = n - 1; i > c.x; i--) {
				map[c.y][i] = ans;
			}
			break;
		case 3:
			for (int i = n - 1; i > c.y; i--) {
				map[i][c.x] = ans;
			}
			break;
		case 4:
			for (int i = 0; i < c.x; i++) {
				map[c.y][i] = ans;
			}
			break;
		}
	}


	public static int getLines() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 2)
					cnt++;
			}
		}
		return cnt;
	}

	public static void dfs(int len, int count, int k) {

		if (len == corelist.size()) {
			if (maxCount < count) {
				maxCount = count;
				minLine = Integer.MAX_VALUE;
			}
			if (maxCount == count) {
				minLine = Math.min(minLine, getLines());
			}
		} else {
			Core c = corelist.get(len);
			for (int i = 1; i <= 4; i++) {
				if (canPut(i, c)) {
					put(i, c, 2);
					putList.push(new Pair(i, len + 1));
					dfs(len + 1, count + 1, i);
				} else {
					dfs(len + 1, count, i);
				}
			}
		}
		if (len > 0) {
			if (!putList.isEmpty()) {
				Pair t = putList.pop();
				if (t.len == len && t.dir == k) {
					put(k, corelist.get(len - 1), 0);
				} else
					putList.push(t);
			}
		}
	}

	public static ArrayList<Integer> getEnableLine(Core c) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean check = true;
		for (int i = 0; i < c.y; i++) {
			if (map[i][c.x] != 0) {
				check = false;
				break;
			}
		}
		if (check)
			list.add(1);
		check = true;

		for (int i = n - 1; i > c.x; i--) {
			if (map[c.y][i] != 0) {
				check = false;
				break;
			}
		}
		if (check)
			list.add(2);
		check = true;

		for (int i = n - 1; i > c.y; i--) {
			if (map[i][c.x] != 0) {
				check = false;
				break;
			}
		}
		if (check)
			list.add(3);
		check = true;
		for (int i = 0; i < c.x; i++) {
			if (map[c.y][i] != 0) {
				check = false;
				break;
			}
		}
		if (check)
			list.add(4);

		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int num = 1; num <= tc; num++) {
			n = sc.nextInt();
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1 && i != 0 && j != 0 && i != n - 1 && j != n - 1)
						corelist.add(new Core(i, j));
				}
			}
			dfs(0, 0, 0);

			System.out.println("#" + num + " " + minLine);
			minLine = Integer.MAX_VALUE;
			putList.clear();
			maxCount = 0;
			corelist.clear();
		}
	}

}
