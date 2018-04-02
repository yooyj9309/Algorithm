package SamsungExpert;

import java.util.ArrayList;
import java.util.Scanner;

public class SW2112 {
	public static int d;
	public static int w;
	public static int k;
	public static int map[][] = null;
	public static int omap[][] = null;
	public static boolean visit[] = null;
	public static int min = Integer.MAX_VALUE;

	public static void init() {
		for (int i = 0; i < d; i++)
			for (int j = 0; j < w; j++)
				map[i][j] = omap[i][j];
	}

	public static void dfs(int v, int len) {
		boolean ans = isOk(len);
		
		if (ans || len == k) {
			if (ans)
				min = Math.min(min, len);
		} else {
			for (int i = v + 1; i <= d; i++) {
				if (!visit[i]) {
					visit[i] = true;
					dfs(i, len + 1);
				}
			}
		}
		visit[v] = false;
	}

	public static String[] guessAll(int len) {
		int size = 0;

		if (len != 0)
			size = (int) Math.pow(2, len);

		String list[] = new String[size];
		for (int i = 0; i < size; i++) {
			String result = Integer.toBinaryString(i);
			while (result.length() < len) {
				result = "0" + result;
			}
			list[i] = result;
		}
		return list;
	}

	public static void injection(int index, int type) {
		for (int i = 0; i < w; i++) {
			map[index][i] = type;
		}
	}


	public static boolean isOk(int len) {
		init();
		boolean val = false;
		String cmp1 = "";
		String cmp2 = "";
		for (int i = 0; i < k; i++) {
			cmp1 += "0";
			cmp2 += "1";
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= d; i++) {
			if (visit[i]) {
				list.add(i - 1);
			}
		}
		String amp[] = guessAll(len);

		if (amp.length == 0) {
			int cnt = 0;
			for (int j = 0; j < w; j++) {
				String a = "";
				for (int i = 0; i < d; i++) {
					a = a + "" + map[i][j];
				}
				if ((a.contains(cmp1) || a.contains(cmp2))) {
					cnt++;
				}

			}
			if (cnt == w) {
				val = true;
			}
		} else {
			for (int str = 0; str < amp.length; str++) {
				for (int p = 0; p < len; p++) {
					int k = Integer.parseInt(amp[str].charAt(p) + "");
					injection(list.get(p), k);
				}
				int cnt = 0;
				for (int j = 0; j < w; j++) {
					String a = "";
					for (int i = 0; i < d; i++) {
						a = a + "" + map[i][j];
					}
					if ((a.contains(cmp1) || a.contains(cmp2))) {
						cnt++;
					}

				}
				if (cnt == w) {
					val = true;
					break;
				}
			}
		}

		return val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int num = 1; num <= tc; num++) {
			d = sc.nextInt();
			w = sc.nextInt();
			k = sc.nextInt();
			visit = new boolean[d + 1];
			map = new int[d][w];
			omap = new int[d][w];

			for (int i = 0; i < d; i++) {
				for (int j = 0; j < w; j++) {
					omap[i][j] = sc.nextInt();

				}
			}
			dfs(0, 0);
			System.out.println("#"+num+" "+min);
			min = Integer.MAX_VALUE;
		}
	}
}