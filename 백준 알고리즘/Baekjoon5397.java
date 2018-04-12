package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Baekjoon5397 {

	
	public static void keyLogger(String str) {
		LinkedList<Character> link = new LinkedList<Character>();
		int cur = 0;
		int size=str.length();
		for (int i = 0; i < size; i++) {
			char s=str.charAt(i);

			switch (s) {
			case '<':
				if (!link.isEmpty()&&cur>0) {
					cur--;
				}
				break;
			case '>':
				if (link.size() != cur) {
					cur++;
				}
				break;
			case '-':
				if (!link.isEmpty()&&cur>0) {
					link.remove(cur - 1);
					cur--;
				}
				break;
			default:
				if (link.size() == cur)
					link.addLast(s);
				else
					link.add(cur, s);
				cur++;
				break;
			}

		}

		for (int i = 0; i < link.size(); i++)
			System.out.print(link.get(i));
		
	}
	public static String keyLogger1(String str)
	{
		Stack<Character> stA=new Stack<Character>();
	    Stack<Character> stB=new Stack<Character>();
		
		int size=str.length();
		char[] s=str.toCharArray();
		for (int i = 0; i < size; i++) {
			switch (s[i]) {
			case '<':
				if(!stA.isEmpty())
					stB.push(stA.pop());
				break;
			case '>':
				if(!stB.isEmpty())
					stA.push(stB.pop());
				break;
			case '-':
				if(!stA.isEmpty())
					stA.pop();
				break;
			default:
				stA.push(s[i]);
				break;
			}
		}
		while(!stB.isEmpty())
			stA.push(stB.pop());
		StringBuilder sb=new StringBuilder();
		while(!stA.isEmpty())
			sb.insert(0, stA.pop());
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());

		for (int i = 0; i < num; i++) {
			String tmp = in.readLine();
			System.out.println(keyLogger1(tmp));
		}
	}

}
