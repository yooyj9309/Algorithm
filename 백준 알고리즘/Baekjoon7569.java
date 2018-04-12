package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Baekjoon7569 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input[] = in.readLine().split(" ");
		int n=Integer.parseInt(input[0]);
		int m=Integer.parseInt(input[1])-1;
		
		LinkedList<Integer> list=new LinkedList<Integer>();
		LinkedList<Integer> answer=new LinkedList<Integer>();
		
		for(int i=1;i<=n;i++)
			list.add(i);
		int idx=0;
		while(!list.isEmpty())
		{
			idx+=m;
			if(idx>=list.size())
				idx=idx%list.size();
			answer.add(list.remove(idx));
		}
		String value=answer.toString();
		value=value.replace("[", "<");
		value=value.replace("]", ">");
		System.out.print(value);
	}

}
