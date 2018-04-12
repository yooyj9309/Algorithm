package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Baekjoon2003 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] list = new int[n + 1];
		for (int i = 0; i < n; i++) {
			list[i] = sc.nextInt();
		}

		int left = 0, right = 0, cnt = 0, sum = list[0];
		while (right != n) {
			if (sum < m) {
				right += 1;
				sum += list[right];
			} else if (sum > m) {
				sum -= list[left];
				left++;
			} else {
				cnt += 1;
				right += 1;
				sum += list[right];

			}
		}
		System.out.println(cnt);
	}

}
