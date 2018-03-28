package Algortihm2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baekjoon10989 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(in.readLine());
		int arr[] = new int[n + 1];
		Arrays.fill(arr, 0);
		for (int i = 1; i <= n; i++) {
			int k = Integer.parseInt(in.readLine());
			arr[k]++;
		}
		for (int i = 1; i < 10000; i++) {
			if (arr[i] > 0) {
				for (int j = 0; j < arr[i]; j++)
					bw.write(i+"\n");
			}
		}
		in.close();
		bw.close();
	}

}
