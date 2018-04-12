package Algortihm2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Baekjoon9466 {
	static int n = 0;
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	static boolean visit[] = null;
	static boolean ans[] = null;

	public static void process(ArrayList<Integer> list) {
		int size=list.size()-1;
		if (size >= 0) {
			int last = list.remove(size);
			boolean check = false;
			for (int i = 0; i < size; i++) {
				int tmp=list.get(i);
				if (last == tmp) {
					check = true;
				}
				if (check) {
					ans[tmp] = true;
				}
				visit[tmp] = true;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			n = sc.nextInt();
			ans = new boolean[n + 1];
			visit = new boolean[n + 1];
			for (int j = 1; j <= n; j++) {
				int tmp=sc.nextInt();
				map.put(j,tmp);
			}
			for (int k = 1; k <= n; k++) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				int j = k;
				while (!visit[j]) {
					list.add(j);
					int next=map.get(j);
					if (list.contains(next)) {
						list.add(next);
						break;
					}
					j = next;
				}
				process(list);				
			}
			int cnt=0;
			for (int l=1;l<=n;l++)
			{
				if(!ans[l])
					cnt++;
			}
			System.out.println(cnt);
		}
		sc.close();
	}

}
