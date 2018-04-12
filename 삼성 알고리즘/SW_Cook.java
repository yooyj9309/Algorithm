package SamsungExpert;

import java.util.Arrays;
import java.util.Scanner;

public class SW_Cook {
	public static int n = 0;
	public static int map[][] = null;
	public static boolean visit[] = null;
	public static int min=Integer.MAX_VALUE;
	
	public static void dfs(int v, int len) {
		if (len == n / 2) {
			int[] arr1 = getArray(true);
			int[] arr2 = getArray(false);
			
			int sumA=getSum(arr1);
			int sumB=getSum(arr2);
			
			min=Math.min(Math.abs(sumA-sumB), min);
			
			//System.out.println("A : "+Arrays.toString(arr1)+" -> " +sumA);
			//System.out.println("B : "+Arrays.toString(arr2)+" -> " +sumB);
		} else {
			for (int i = v + 1; i <= n; i++) {
				if (!visit[i]) {
					visit[i] = true;
					dfs(i, len + 1);
				}
			}
		}
		visit[v] = false;
	}
	
	public static int getSum(int[] arr)
	{
		int size=arr.length;
		int sum=0;
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				sum+=map[arr[i]][arr[j]];
				sum+=map[arr[j]][arr[i]];
			}
		}
		return sum;
	}
	public static int[] getArray(boolean type) {
		int arr[] = new int[n / 2];
		int p = 0;
		for (int i = 1; i <= n; i++) {
			if (visit[i] == type) {
				arr[p] = i;
				p++;
			}
		}
		return arr;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int num = 1; num <= tc; num++) {
			n = sc.nextInt();
			map = new int[n + 1][n + 1];
			visit = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			dfs(0, 0);
			System.out.println("#"+num+" "+min);
			min=Integer.MAX_VALUE;
		}
	}

}
