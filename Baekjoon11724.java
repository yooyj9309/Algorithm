package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon11724 {
	static int map[][] = null;
	public static int getNotVisit(int [] visit)
	{
		int value=0;
		for(int i=1;i<visit.length;i++)
		{
			if(visit[i]==0)
			{
				value++;
			}
		}
		return value;
	}
	public static void full(int k,int size)
	{
		for(int i=0;i<size;i++)
		{
			map[i][k]=0;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		map = new int[n + 1][n + 1];
		int visit[] = new int[n + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		Arrays.fill(visit, 0);
		for (int i = 0; i < m; i++) {
			input = in.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);

			map[y][x] = 1;
			map[x][y] = 1;
		}
		int count = 0;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (map[i][j] == 1) {
					for (int k = j; k < n + 1; k++) {
						if (visit[k] != 1 && map[i][k] != 0) {
							q.add(k);
							visit[k]=1;
							map[i][k]=0;
							full(k,n+1);
						}
					}
					while (!q.isEmpty()) {
						int t = q.poll();
						for (int k = 0; k < n + 1; k++) {
							if (visit[k] != 1 && map[t][k] == 1) {
								q.add(k);
								map[t][k] = 0;
								visit[k]=1;
								full(k,n+1);
							}
						}

					}
				count++;
				}

			}
		}
		if(getNotVisit(visit)==0)
			System.out.println(count);
		else
		{
			System.out.println(count+getNotVisit(visit));
		}
	}

}
