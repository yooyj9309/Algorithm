package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Baekjoon2164 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());

		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= num; i++)
			list.add(i);
		if (list.size() == 1)
			System.out.println(list.get(0));
		else {
			while (list.size() != 1) {
				list.removeFirst();
				list.addLast(list.removeFirst());
			}
			System.out.println(list.get(0));
		}
	}

}
