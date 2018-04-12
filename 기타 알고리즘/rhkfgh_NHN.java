import java.util.Scanner;
import java.util.Stack;

public class rhkfgh_NHN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		for (int idx = 0; idx < n; idx++) {
			String s = scan.next();
			int i = 0;
			Stack<String> stack = new Stack<String>();
			boolean is = true;

			while (s.length() > i&&is) {
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
					if (!stack.isEmpty()){
						if(!stack.pop().equals("("))
						is = false;
					}
					else
						is= false;
					break;
				case "}":
					if (!stack.isEmpty()){
						if(!stack.pop().equals("{"))
						is = false;
					}
					else
						is= false;
					break;
				case "]":
					if (!stack.isEmpty()){
						if(!stack.pop().equals("["))
						is = false;
					}
					else
						is= false;
					break;
				default:
					break;
				}
				i++;
			}
			
			if (is&&stack.isEmpty())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
