import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon1744 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> plus = new ArrayList<Integer>();
		ArrayList<Integer> minus = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			if (tmp > 0)
				plus.add(tmp);
			else
				minus.add(tmp);
		}
		Collections.sort(plus);
		Collections.sort(minus);
		Collections.reverse(plus);

		int sum = 0;

		for (int i = 0; i < plus.size(); i = i + 2) {
			if (i + 1 < plus.size()) {
				if (plus.get(i) != 1 && plus.get(i + 1) != 1)
					sum += plus.get(i) * plus.get(i + 1);
				else
					sum += plus.get(i) + plus.get(i + 1);
			}
		}
		
		if (plus.size() % 2 == 1)
			sum += plus.get(plus.size() - 1);

		for (int i = 0; i < minus.size(); i = i + 2) {
			if (i + 1 < minus.size()) {
				if (minus.get(i) != 1 && minus.get(i + 1) != 1)
					sum += minus.get(i) * minus.get(i + 1);
				else
					sum += minus.get(i) + minus.get(i + 1);
			}
		}
		if (minus.size() % 2 == 1)
			sum += minus.get(minus.size() - 1);
		System.out.println(sum);
	}

}
