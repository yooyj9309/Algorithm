package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1592 {
	static int cnt[];

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input[] = in.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int l = Integer.parseInt(input[2]);

		cnt = new int[n + 1];
		Arrays.fill(cnt,0);
		int start=1;
		int count=0;
		while (true) {
			cnt[start]++;
			if(cnt[start]==m)
				break;
			count++;
			if(cnt[start]%2==0)
			{
				if(start-l>=1)
					start=start-l;
				else
					start=n+(start-l);
			}
			else
				start=(start+l-1)%n+1;	
		}
		System.out.println(count);
	}

}
