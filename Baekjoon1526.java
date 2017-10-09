package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1526 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String tmp = in.readLine();
		int num = Integer.parseInt(tmp);
		Queue<Integer> q = new LinkedList<Integer>();
		int ans = 0;
		if (num >= 4) {
			q.add(4);
			ans = 4;
		}
		if (num >= 7) {
			q.add(7);
			ans = 7;
		}
		while (!q.isEmpty()) {
			int tmp1 = q.peek();
			q.poll();
			tmp1 *= 10;
			if (tmp1 + 4 <= num) {
				ans = tmp1 + 4;
				q.add(ans);
			}
			if (tmp1 + 7 <= num) {
				ans = tmp1 + 7;
				q.add(ans);
			}
		}
		System.out.println(ans);
	}

}
