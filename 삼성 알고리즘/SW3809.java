package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeSet;

public class SW3809 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int num = 1; num <= tc; num++) {
			int n = sc.nextInt();
			String str = "";
			int arr[] = new int[n];
			boolean flag = false;
			boolean visit[]=new boolean[1001];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
				if (!flag && arr[i] == 0)
					flag = true;
				str += arr[i];
			}
			if (flag) {
				int ans = 0;
				boolean p=false;
				for (int i = 1; i <= n; i++) {
					for (int j = 0; j + i <= n; j++) {
							int tmp = Integer.parseInt(str.substring(j, j + i));
							visit[tmp]=true;
					}
					int amount=(int)Math.pow(10, i);
					for(int k=0;k<amount;k++)
					{
						if(!visit[k])
						{
							ans=k;
							p=true;
							break;
						}
					}
					if(p)
						break;
				}
				System.out.println("#" + num + " " + ans);
			} else
				System.out.println("#" + num + " " + 0);
		}
	}

}
