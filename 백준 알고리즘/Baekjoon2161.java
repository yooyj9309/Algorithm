package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Baekjoon2161 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(in.readLine());
		LinkedList<Integer> lists=new LinkedList<Integer>();
		
		for(int i=1;i<=num;i++)
			lists.add(i);
		
		while(true)
		{
			System.out.print(lists.removeFirst()+" ");
			
			if(!lists.isEmpty())
				lists.addLast(lists.removeFirst());
			else
				break;
		}
		
	}

}
