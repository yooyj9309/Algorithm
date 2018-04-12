package Algortihm2;

import java.util.Scanner;

public class Baekjoon15652 {
	static int n, m;

	public static void dfs(int v, int len,int[] arr) {
		if (len == m) {
			for(int a:arr)
				System.out.print(a+" ");
			System.out.println();
			return;
		}
		for (int i = v; i <= n; i++) {
			arr[len]=i;
			dfs(i, len + 1,arr);
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int arr[]=new int[m];
		dfs(1, 0,arr);

	}

}
