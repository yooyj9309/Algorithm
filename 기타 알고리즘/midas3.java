import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class midas3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt(), weight = 4;
		int input[] = new int[num + 1];

		LinkedList<Integer> val = new LinkedList<Integer>();

		for (int i = 1; i <= num; i++) {
			input[i] = scan.nextInt();
		}

		for (int i = 1; i <= num; i++) {
			int ctrlCheck = input[i];
			int cnt = 0;
			for (int j = i; j <= num; j++) {
				if (ctrlCheck + 4 >= input[j])
					cnt++;
				else
					break;

			}
			val.addLast(cnt);

		}
		int result = 0;
		int ctrl = 1;
		while (ctrl <= num) {
			ctrl = ctrl + input[ctrl];
			result++;

		}
		System.out.println(result);

	}

}
