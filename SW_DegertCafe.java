package SamsungExpert;

import java.util.Scanner;

public class SW_DegertCafe {
	static int n = 0;
	static int map[][] = null;
	static int showMap[][]=null;
	static boolean visit[][] = null;
	static boolean v[] = null;
	static int ax[] = { 1, -1, -1, 1 };
	static int ay[] = { 1, 1, -1, -1 };
	static int max = 0;
	static int direction[] = null;

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int num = 1; num <= tc; num++) {
			n = sc.nextInt();
			map = new int[n][n];
			showMap=new int[n][n];
			visit = new boolean[n][n];
			v = new boolean[101];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					direction = new int[4];
					//dfs(i, j, i, j, 0, 0, direction);
				}
			}
			if(max==0)
				System.out.println(-1);
			else
				System.out.println(max);
			max=0;
		}
	}

}
