package Algortihm2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon2668 {

	static int[] arr = null;
	static boolean[] visit = null;
	static int n = 0;
	static int max = 0;
	static int answer[] = null;

	public static void dfs(int v, int len) {
		if (collect()) {
			if (max < len) {
				max = len;
				int k = 0;
				for (int i = 1; i <= n; i++) {
					if (visit[i]) {
						answer[k] = i;
						k++;
					}
				}
			}
		}

		if (v == n) {

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

	public static boolean isAllFalse() {
		boolean v = true;
		for (boolean a : visit) {
			if (a) {
				v = false;
				break;
			}
		}
		return v;
	}

	public static boolean collect() {

		boolean val = true;
		if (!isAllFalse()) {
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			ArrayList<Integer> tmp1 = new ArrayList<Integer>();
			for (int i = 1; i <= n; i++) {
				if (visit[i]) {
					tmp.add(i);
					tmp1.add(arr[i]);
				}
			}
			Collections.sort(tmp);
			Collections.sort(tmp1);
			for (int i = 0; i < tmp.size(); i++) {
				if (tmp.get(i) != tmp1.get(i)) {
					val = false;
					break;
				}
			}
		} else
			val = false;
		return val;
	}

	public static boolean collect(ArrayList<Integer> list) {
		boolean val = true;
		int size = list.size();
		int tmp[] = new int[size];
		if (size == 0)
			val = false;
		else {
			for (int i = 0; i < size; i++)
				tmp[i] = arr[list.get(i)];
			Collections.sort(list);
			Arrays.sort(tmp);

			for (int i = 0; i < size; i++) {
				if (list.get(i) != tmp[i]) {
					val = false;
					break;
				}
			}
		}
		return val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n + 1];
		visit = new boolean[n + 1];
		answer = new int[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = sc.nextInt();

		dfs(0, 0);
		System.out.println(max);
		for (int i = 0; i <= n; i++) {
			if(answer[i]!=0)
			System.out.println(answer[i] + " ");
		}
	}

}
