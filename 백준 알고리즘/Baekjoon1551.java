package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Baekjoon1551 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int wantNum = Integer.parseInt(in.readLine().split(" ")[1]);
		String[] str = in.readLine().split(",");
		LinkedList<Integer> input = new LinkedList<Integer>();
		String result = "";

		for (int i = 0; i < str.length; i++)
			input.add(Integer.parseInt(str[i]));

		for (int i = 0; i < wantNum; i++) {
			int size=input.size();
			for (int j = 1; j < size; j++) {
				int tmp = input.get(j) - input.get(j - 1);
				input.add(tmp);
			}
			for(int k=0;k<size;k++)
				input.removeFirst();
		}
		for(int a:input){
		result=result+a+",";
		}
		System.out.print(result.substring(0, result.length()-1));
	}

}
