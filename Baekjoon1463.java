package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1463 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		int arr[] = new int[num + 1];

		if (num == 1 || num == 2 || num == 3) {
			if (num == 1)
				System.out.println(0);
			else
				System.out.println(1);
		} else {
			arr[1] = 0;
			arr[2] = 1;
			arr[3] = 1;
			for (int i = 4; i <= num; i++) {
				int cmp1 = Integer.MAX_VALUE, cmp2 = Integer.MAX_VALUE, cmp3 = Integer.MAX_VALUE;
				if (i % 2 == 0)
					cmp1 = arr[i / 2] + 1;
				if (i % 3 == 0)
					cmp2 = arr[i / 3] + 1;
				if (i - 1 != 1)
					cmp3 = arr[i - 1] + 1;
				
				arr[i] = Math.min(cmp1, Math.min(cmp2, cmp3));
				
			}
			System.out.println();
			System.out.println(arr[num]);
		}
	}

}
