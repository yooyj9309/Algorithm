package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon10828 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < num; i++) {
			String input = in.readLine();
			if (input.contains("push")) {
				stack.push(Integer.parseInt(input.split(" ")[1]));
			} else {
				switch (input) {
				case "top":
					if (stack.isEmpty())
						System.out.println(-1);
					else
						System.out.println(stack.peek());
					break;
				case "size":
					System.out.println(stack.size());
					break;
				case "empty":
					if (stack.isEmpty())
						System.out.println(1);
					else
						System.out.println(0);
					break;
				case "pop":
					if (stack.isEmpty())
						System.out.println(-1);
					else
						System.out.println(stack.pop());
					break;
				}
			}
		}
	}

}
