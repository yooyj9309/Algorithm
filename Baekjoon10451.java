package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon10451 {
	public static int getCycle(int[] lists) {
		int value = 0;
		boolean[] checkList = new boolean[lists.length];
		Arrays.fill(checkList, true);
		int first = 0;
		for (int i = 1; i < lists.length; i++) {
			if (!checkList[i])
				continue;
			else {
				first = i;
				int j=0;
				for (j = first; first != lists[j]; j = lists[j])
					checkList[j] = false;
				checkList[j] = false;
				value++;
			}

		}
		return value;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());

		for (int i = 0; i < n; i++) {
			int size = Integer.parseInt(in.readLine());
			int[] inputList = new int[size + 1];
			String[] lists = in.readLine().split(" ");

			for (int j = 1; j <= size; j++)
				inputList[j] = Integer.parseInt(lists[j - 1]);
			System.out.println(getCycle(inputList));
		}
	}

}
