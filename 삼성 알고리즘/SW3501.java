package SamsungExpert;

import java.util.Arrays;
import java.util.Scanner;

public class SW3501 {
	public static String solution(int a, int b) {
		int max = 1000001;
		int sp = 0;
		int stack[] = new int[max];
		int index[] = new int[max];

		String str = "";
		Arrays.fill(index, -1);

		int q = a / b;
		int r = a % b;
		int circulation = 0, cidx = -1;

		if (r == 0)
			str += q;
		else
			str += q + ".";

		while (r != 0) {
			if (sp != 0) {
				if (index[r] >= 0) {
					circulation = 1;
					cidx = index[r];
					break;
				}
			}
			if (r != 0) {
				stack[sp++] = r;
				index[r] = ++cidx;

				a = r * 10;
				q = a / b;
				r = a % b;
			}
		}
		for (int i = 0; i < sp; i++) {
			if (circulation != 0 && cidx == i) {
				str += "(";
			}
			str += (stack[i] * 10) / b;
		}
		if (circulation != 0) {
			str += ")";
		}
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		for(int i=1;i<=tc;i++)
		{
			int num1=sc.nextInt();
			int num2=sc.nextInt();
			System.out.println("#"+i+" "+solution(num1,num2));
		}
	}

}
