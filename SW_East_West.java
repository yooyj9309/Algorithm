package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_East_West {
	static int n = 0, m = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(in.readLine());
		for (int num = 1; num <= tc; num++) {
			String input[] = in.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			int w[] = new int[n + 1];
			int e[] = new int[n + 1];
			int wtoE[] = new int[n + 1];
			int etoW[] = new int[n + 2];

			char list[][] = new char[m + 1][n + 1];
			for (int i = 0; i < m; i++) {
				String s=in.readLine();
				for (int j = 1; j <= n; j++) {
					list[i][j]=s.toCharArray()[j-1];
					if (list[i][j] == 'W')
						w[j-1]++;
					else
						e[j]++;
				}
			}
			for (int j = 1; j <= n; j++) {
				wtoE[j] = wtoE[j - 1] + e[j];
			}
			for (int j = n; j >= 0; j--) {
				etoW[j] = etoW[j + 1] + w[j];
			}
			
			int min=Integer.MAX_VALUE;
			int idx=0;
			for(int i=0;i<=n;i++)
			{
				int sum=wtoE[i]+etoW[i];
				if(min>sum)
				{
					min=sum;
					idx=i;
				}
			}
			System.out.println("#"+num+" "+idx+" "+(idx+1));
		}
	}

}
