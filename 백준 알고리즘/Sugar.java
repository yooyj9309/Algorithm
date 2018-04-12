import java.util.Scanner;

public class Sugar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int first = n;
		int result = -1;
		n = n % 5;

		if (n == 0) {
			result = first / 5;
		} else if (n % 3 == 0) {
			result = first / 5 + ((first % 5) / 3);
		} else if (n % 3 != 0) {
			int i=0;
			for (int temp = n + 5; first >= temp; temp = temp + 5) {
				i++;
				if (temp % 3 == 0) {
					result = first / 5 + temp / 3-i;
					break;
				}
			}
		}
		System.out.println(result);
	}
}
