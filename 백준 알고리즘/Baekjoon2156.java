package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2156 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine().split(" ")[0]);
		int d[] = new int[num + 1];
		int arr[] = new int[num + 1];

		for (int i = 1; i <= num; i++)
			arr[i] = Integer.parseInt(in.readLine().split(" ")[0]);

		d[0] = 0;
		d[1] = arr[1];

		if (num == 1)
		{}
		else if (num == 2)
		{
			d[2] = arr[1] + arr[2];
		}
		else {
			d[2] = arr[1] + arr[2];
			for (int i = 3; i <= num; i++) {
				int result = Math.max(d[i - 2] + arr[i], d[i - 1]);
				result = Math.max(result, arr[i] + arr[i - 1] + d[i - 3]);
				d[i] = result;
			}
		}
		System.out.println(d[num]);
	}

}
