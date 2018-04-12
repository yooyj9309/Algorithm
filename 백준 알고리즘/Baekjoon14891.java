package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon14891 {
	static LinkedList<String> list[] = new LinkedList[4];

	public static LinkedList<String> getRotateRight(LinkedList<String> list) {
		list.add(0, list.remove(list.size() - 1));
		return list;
	}

	public static LinkedList<String> getRotateLeft(LinkedList<String> list) {
		list.add(list.size() - 1, list.remove(0));
		return list;
	}
	
	public static void rotateAll(int num, int bang) {
		num -= 1;
		int checkList[] = new int[4];
		Arrays.fill(checkList, 0);
		checkList[num] = bang;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		while (!q.isEmpty()) {
			int n=q.poll();
			if (n - 1 >= 0) {
				if (checkList[n-1]==0&&!list[n - 1].get(2).equals(list[n].get(6))) {
					q.add(n - 1);
					checkList[n-1]=checkList[n]*-1;
				}
			}
			if (n + 1 <=3) {
				if (checkList[n+1]==0&&!list[n + 1].get(6).equals(list[n].get(2))) {
					q.add(n + 1);
					checkList[n+1]=checkList[n]*-1;
				}
			}
		}
		for(int i=0;i<4;i++)
		{
			if(checkList[i]==-1)
				list[i]=getRotateLeft(list[i]);
			else if(checkList[i]==1)
				list[i]=getRotateRight(list[i]);
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			list[i] = new LinkedList<String>();
			String tmp = in.readLine();
			for (int j = 0; j < 8; j++)
				list[i].add(tmp.charAt(j) + "");
		}
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			String input[] = in.readLine().split(" ");
			int number = Integer.parseInt(input[0]);
			int bang = Integer.parseInt(input[1]);
			rotateAll(number, bang);
		}
		int value=0;
		for(int i=0;i<4;i++)
		{
			if(list[i].get(0).equals("1"))
				value+=Math.pow(2, i);
		}
		System.out.println(value);
	}

}
