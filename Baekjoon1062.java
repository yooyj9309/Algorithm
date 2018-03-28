package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1062 {
	static boolean[] c = new boolean[26];

	public static int getNumber(String a, String b) {
		int cnt = 0;

		for (int p = 0; p < a.length(); p++)
			c[a.charAt(p) - 'a'] = true;

		for (int p = 0; p < b.length(); p++)
			c[b.charAt(p) - 'a'] = true;

		for (int i = 0; i < 26; i++) {
			if (c[i])
				cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);

		String[] str = new String[n];

		for (int i = 0; i < n; i++) {
			String tmp = in.readLine();
			str[i] = tmp.substring(4, tmp.length() - 4);
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			int ans = 1;
			Arrays.fill(c, false);
			for (int j = i + 1; j < n; j++) {
				if (getNumber(str[i], str[j]) <= k)
					ans++;
			}
			max = Math.max(max, ans);
		}
		System.out.println(max);
	}

}
