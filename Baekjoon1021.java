package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Baekjoon1021 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> list = new LinkedList<Integer>();
		String[] inputString = in.readLine().split(" ");
		String[] inputArray = in.readLine().split(" ");
		
		int n = Integer.parseInt(inputString[0]);
		int m = Integer.parseInt(inputString[1]);

		for(int i=1;i<=n;i++)
			list.add(i);
		
		int cnt=0;
		
		for (int i = 0; i < inputArray.length; i++) {
			int num = Integer.parseInt(inputArray[i]);

			while (true) {
				int pos = list.indexOf(num);
				int left=pos;
				int right=list.size()-pos-1;
				
				if(left==0)
				{
					list.remove(pos);
					break;
				}
				if(left>right)
				{
					list.addFirst(list.removeLast());
					cnt++;
				}
				else
				{
					list.addLast(list.removeFirst());
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

}
