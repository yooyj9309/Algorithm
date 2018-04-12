package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Robot {
	int r, c, d;

	public Robot(int r, int c, int d) {
		this.r = r;
		this.c = c;
		this.d = d;
	}
}

public class Baekjoon14503 {
	static int n = 0, m = 0;
	static int map[][] = null;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input[] = in.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		input = in.readLine().split(" ");
		Robot robot = new Robot(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			input = in.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		clean(robot);
		System.out.println(getCleanNum(robot));
	}

	public static int getCleanNum(Robot r) {
		while (true) {
			if (!isAllBlock(r)) {
				r.d = getLeftRotation(r.d);
				if (searchLeft(r)) {
					clean(r);
				} else if (!searchLeft(r)) {
					continue;
				}
			} else if (isAllBlock(r)) {
				int direction = getBehindWall(r);
				if (getBehindWall(r) == -1)
					break;
				else {
					switch (direction) {
					case 0:
						r.r -= 1;
						break;
					case 1:
						r.c += 1;
						break;
					case 2:
						r.r += 1;
						break;
					case 3:
						r.c -= 1;
						break;
					}
				}
			}
		}
		return countClean();
	}

	public static boolean searchLeft(Robot r) {
		boolean value = false;
		switch (r.d) {
		case 0:
			if (r.r - 1 >= 0)
				if (map[r.r - 1][r.c] == 0) {
					r.r -= 1;
					value = true;
				}
			break;
		case 1:
			if (r.c + 1 < m)
				if (map[r.r][r.c + 1] == 0) {
					r.c += 1;
					value = true;
				}
			break;
		case 2:
			if (r.r + 1 < n)
				if (map[r.r + 1][r.c] == 0) {
					r.r += 1;
					value = true;
				}
			break;
		case 3:
			if (r.c - 1 >= 0)
				if (map[r.r][r.c - 1] == 0) {
					r.c -= 1;
					value = true;
				}
			break;
		}
		return value;
	}

	public static boolean isAllBlock(Robot r) {
		boolean value = true;
		if (r.r + 1 < n && r.r - 1 >= 0 && r.c + 1 < m && r.c - 1 >= 0) {
			if (map[r.r + 1][r.c] == 0)
				value = false;
			if (map[r.r][r.c + 1] == 0)
				value = false;
			if (map[r.r - 1][r.c] == 0)
				value = false;
			if (map[r.r][r.c - 1] == 0)
				value = false;
		}
		return value;
	}

	public static int getBehindWall(Robot r) {
		int tmp = getLeftRotation(getLeftRotation(r.d));
		int value = tmp;
		switch (tmp) {
		case 0:
			if (map[r.r - 1][r.c] == 1)
				value = -1;
			break;
		case 1:
			if (map[r.r][r.c + 1] == 1)
				value = -1;
			break;
		case 2:
			if (map[r.r + 1][r.c] == 1)
				value = -1;
			break;
		case 3:
			if (map[r.r][r.c - 1] == 1)
				value = -1;
			break;
		}
		return value;
	}

	public static int getLeftRotation(int r) {
		if (r != 0)
			return r - 1;
		else
			return 3;
	}

	public static void clean(Robot r) {
		map[r.r][r.c] = 2;
	}

	public static int countClean() {
		int cnt = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2)
					cnt++;
			}
		return cnt;
	}
}
