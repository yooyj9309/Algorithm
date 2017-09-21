import java.util.Scanner;
import java.util.Stack;

public class NHN3 {
	static int arr[];

	public static boolean isValid(String s) {
		int i = 0;
		Stack<String> stack = new Stack<String>();
		boolean is = true;

		while (s.length() > i && is) {
			String str = s.substring(i, i + 1);

			switch (str) {
			case "(":
				stack.add(str);

				break;
			case "{":
				stack.add(str);
				break;
			case "[":
				stack.add(str);
				break;
			case ")":
				if (!stack.isEmpty()) {
					if (!stack.pop().equals("("))
						is = false;
				} else
					is = false;
				break;
			case "}":
				if (!stack.isEmpty()) {
					if (!stack.pop().equals("{"))
						is = false;
				} else
					is = false;
				break;
			case "]":
				if (!stack.isEmpty()) {
					if (!stack.pop().equals("["))
						is = false;
				} else
					is = false;
				break;
			default:
				
				break;
			}
			i++;
		}
		if (is && stack.isEmpty())
			return true;
		else
			return false;
	}

	public static void success(String s) {
		int i = 0;
		Stack<String> stack = new Stack<String>();
		boolean is = true;
		int answer = 0;
		while (s.length() > i) {
			String str = s.substring(i, i + 1);

			switch (str) {
			case "(":
				stack.add(str);
				System.out.print(answer+" ");
				answer++;
				break;
			case "{":
				stack.add(str);
				System.out.print(answer+" ");
				answer++;
				break;
			case "[":
				stack.add(str);
				System.out.print(answer+" ");
				answer++;
				break;
			case ")":
				if (!stack.isEmpty()) {
					answer--;
					System.out.print(answer+" ");	
				}
				break;
			case "}":
				if (!stack.isEmpty()) {
					answer--;
					System.out.print(answer+" ");
				}
				break;
			case "]":
				if (!stack.isEmpty()) {
					answer--;
					System.out.print(answer+" ");		
				}
				break;
			default:
				System.out.print(answer+" ");
				break;
			}
			i++;
		}

	}
	public static int fail(String s) {
		int i = 0;
		int result=0;
		Stack<String> stack = new Stack<String>();
		boolean is = true;
		int a =- 1;
		while (s.length() > i && is) {
			String str = s.substring(i, i + 1);

			switch (str) {
			case "(":
				stack.add(str);
				break;
			case "{":
				stack.add(str);
				break;
			case "[":
				stack.add(str);
				break;
			case ")":
				if(a == -1) a = i;
				if (!stack.isEmpty()) {
					if (!stack.pop().equals("(")){
						result=i;
						is = false;
					}
				} else{
					is = false;
					result=-1;
				}
				break;
			case "}":
				if(a == -1) a = i;
				if (!stack.isEmpty()) {
					if (!stack.pop().equals("{"))
						is = false;
				} else{
					is = false;
					result=-1;
				}
				break;
			case "]":
				if(a == -1) a = i;
				if (!stack.isEmpty()) {
					if (!stack.pop().equals("["))
						is = false;
				} else{
					is = false;
					result=-1;
				}
				break;
			default:
				break;
			}
			i++;
		}

		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		for (int idx = 0; idx < n; idx++) {
			String s = scan.next();
			if (isValid(s)) {
				success(s);
				System.out.println();
			}
			else
				System.out.println(fail(s));
				
		}
	}
}
