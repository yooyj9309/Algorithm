package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2160 {

	public static int similar(int arr[][], int arr1[][]) {
		int cnt = 0;
		for (int k = 0; k < 5; k++) {
			for (int j = 0; j < 7; j++) {
				if ((arr[k][j] ^ arr1[k][j]) == 1)
					cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		int arr[][][] = new int[num][5][7];

		for (int i = 0; i < num; i++) {
			for (int k = 0; k < 5; k++) {
				char tmp[] = in.readLine().toCharArray();
				for (int j = 0; j < 7; j++) {
					if (tmp[j] == '.')
						arr[i][k][j] = 1;
					else
						arr[i][k][j] = 0;
				}
			}
		}
		int min = 100000;
		int ans1=0,ans2=0;
		for (int i = 0; i < num; i++) {
			for (int j = i + 1; j < num; j++) {
				if (min > similar(arr[i], arr[j])){
					min = similar(arr[i], arr[j]);
					ans1=i+1;
					ans2=j+1;
				}
			}
		}
		System.out.println(ans1+ " "+ans2);
	}

}
