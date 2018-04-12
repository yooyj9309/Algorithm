package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Baekjoon1759 {
	public static char arr[] = null;
	public static boolean visit[] = null;
	public static int l, c;

	public static String makeString() {
		String val = "";
		for (int i = 0; i < visit.length; i++) {
			if (visit[i])
				val += arr[i];
		}
		return val;
	}

	public static int getMoum(String tmp, String str) {
		int val = 0;
		Pattern p = Pattern.compile(tmp);
		Matcher m = p.matcher(str);
		while (m.find())
			val++;
		return val;
	}

	public static boolean isOk(String str) {
		int sum = 0;
		String tmp[] = { "a", "e", "i", "o", "u" };
		for (int i = 0; i < 5; i++)
			sum += getMoum(tmp[i], str);

		if (sum < 1)
			return false;
		else if (str.length() - sum < 2)
			return false;
		else
			return true;
	}

	public static void dfs(int v, int len) {

		if (len == l) {
			String varify = makeString();
			if (isOk(varify))
				System.out.println(varify);
		} else {
			for (int i = v + 1; i < arr.length; i++) {
				if (!visit[i]) {
					visit[i] = true;
					dfs(i, len + 1);
				}
			}
		}
		visit[v] = false;

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String tmp[] = in.readLine().split(" ");
		l = Integer.parseInt(tmp[0]);
		c = Integer.parseInt(tmp[1]);

		String input[] = in.readLine().split(" ");
		arr = new char[c + 1];
		visit = new boolean[c + 1];
		for (int i = 1; i <= c; i++) {
			arr[i] = input[i - 1].charAt(0);
		}
		Arrays.sort(arr);
		dfs(0, 0);
	}

}
