package SamsungExpert;

import java.util.Scanner;

public class SW_Operation {
	public static int operation[] = new int[4];
	public static int numbers[] = null;
	public static int max = -100000001;
	public static int min = Integer.MAX_VALUE;
	public static int n = 0;

	public static void dfs(int[] operation, int sum, int len) {
		if (len == n) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			
			if (operation[i] > 0) {
				operation[i]--;
				switch (i) {
				case 0:
					dfs(operation, sum + numbers[len], len + 1);
					break;
				case 1:
					dfs(operation, sum - numbers[len], len + 1);
					break;
				case 2:
					dfs(operation, sum * numbers[len], len + 1);
					break;
				case 3:
					dfs(operation, sum / numbers[len], len + 1);
					break;
				}
				operation[i]++;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int num = 1; num <= tc; num++) {
			n = sc.nextInt();

			for (int i = 0; i < 4; i++)
				operation[i] = sc.nextInt();

			numbers = new int[n];
	
			for (int i = 0; i < n; i++)
				numbers[i] = sc.nextInt();

			dfs(operation, numbers[0], 1);
			System.out.println("#" + num + " " + (max - min));
			max = -100000001;
			min = Integer.MAX_VALUE;
		}
	}

}
