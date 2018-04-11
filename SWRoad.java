package SamsungExpert;

import java.util.Scanner;

public class SWRoad {
	static int n, x;
	static int map[][] = null;
	static int height[] = null;

	public static boolean isFlat(int start, int end) {
		if ((0 <= start && start < n) && (0 <= end && end < n)) {
			int check = height[start];
			for (int i = start; i <= end; i++) {
				if (check != height[i])
					return false;
			}
			return true;
		} else
			return false;
	}

	public static boolean canRunway() {
		boolean aslope[] = new boolean[n];// 내려가는거
		boolean bslope[] = new boolean[n];// 올라가는거

		for (int i = 1; i < n; i++) {
			if (Math.abs(height[i - 1] - height[i]) > 1) {
				return false;
			}
		} // 2이상 차이나면 걍 false;

		for (int i = 0; i < n - 1; i++) {
			if (height[i] == height[i + 1] + 1) {
				int start = i + 1;
				int end = i + x;
				if (isFlat(start, end)) {
					for(int t=start;t<=end;t++)
						aslope[t]=true;
				}
				else
					return false;

			} else if (height[i] + 1 == height[i + 1]) {
				int start = i + 1 - x;
				int end = i;
				if (isFlat(start, end)) {
					for(int t=start;t<=end;t++)
						bslope[t]=true;
				}
				else
					return false;
			}
		}
		for(int i=0;i<n;i++)
		{
			if(aslope[i]==true&&bslope[i]==true)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int num = 1; num <= tc; num++) {
			n = sc.nextInt();
			x = sc.nextInt();
			height = new int[n];
			map = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int cnt = 0, cnt1 = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					height[j] = map[i][j];
				}
				if (canRunway()) {
					cnt++;
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					height[j] = map[j][i];
				}
				if (canRunway()) {
					cnt1++;
				}
			}
			System.out.println("#" + num + " " + (cnt + cnt1));
		}
	}

}
