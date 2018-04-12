package SamsungExpert;

import java.util.Scanner;

public class SW2112 {
	public static int d;
	public static int w;
	public static int k;

	public static int map[][] = null;
	public static int omap[][] = null;
	public static int min = Integer.MAX_VALUE;

	public static void injection(int index, int type) {
		for (int i = 0; i < w; i++) {
			map[index][i] = type;
		}
	}

	public static void dfs(int count, int len) {
		boolean tmp = isOk();
		
		if (tmp) {
			min = Math.min(count, min);
		}
		if (count >= min)
			return;
		if (len == d) {
			return;
		} else {
			dfs(count, len + 1);
			injection(len, 0);
			dfs(count + 1, len + 1);
			injection(len, 1);
			dfs(count + 1, len + 1);
			
			if (len > 0)
				undo(len - 1);
		}
		
	}

	public static void init() {
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < w; j++) {
				map[i][j] = omap[i][j];
			}
		}
	}

	public static boolean isOk() {
		String checkA = "";
		String checkB = "";

		for (int i = 0; i < k; i++) {
			checkA += "0";
			checkB += "1";
		}
		boolean ispass = true;

		for (int i = 0; i < w; i++) {
			String cmp = "";
			for (int j = 0; j < d; j++) {
				cmp += map[j][i];
			}
			if (!cmp.contains(checkB) && !cmp.contains(checkA)) {
				ispass = false;
				break;
			}
		}
		return ispass;
	}

	public static void undo(int len) {
		for (int j = len; j < d; j++)
			for (int i = 0; i < w; i++) {
				map[j][i] = omap[j][i];
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int num = 1; num <= tc; num++) {
			d = sc.nextInt();
			w = sc.nextInt();
			k = sc.nextInt();

			map = new int[d][w];
			omap = new int[d][w];

			for (int i = 0; i < d; i++) {
				for (int j = 0; j < w; j++) {
					omap[i][j] = sc.nextInt();
					map[i][j] = omap[i][j];
				}
			}
			map[0][0] = 1;

			dfs(0, 0);
			System.out.println("#" + num + " " + min);
			min = Integer.MAX_VALUE;
		}
	}
}