package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_View {

	public static int getMax(int h1, int h2, int h3, int h4) {
		return Math.max(Math.max(h1, h2), Math.max(h3, h4));
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int k = 1; k <= 10; k++) {
			int n = Integer.parseInt(in.readLine());
			String height[] = in.readLine().split(" ");
			int view[] = new int[height.length];
			for (int i = 0; i < height.length; i++) {
				view[i] = Integer.parseInt(height[i]);
			}
			int cnt = 0;
			for (int i = 0; i < height.length; i++) {
				if (view[i] == 0)
					continue;
				int max = getMax(view[i - 2], view[i - 1], view[i + 1], view[i + 2]);

				if (view[i] > max) {
					cnt += view[i] - max;
				}
			}
			System.out.println("#"+k+" "+cnt);
		}
	}
}
