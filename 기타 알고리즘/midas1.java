import java.util.Arrays;
import java.util.Scanner;

public class midas1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, m, k;
		int count = 0;
		int arr[][] = new int[10][10];

		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		k = scan.nextInt();

		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
			{
				arr[i][j]=0;
			}
		int r, c1, c2;
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				arr[i][j] = 0;

		while (k-- > 0) {
			r = scan.nextInt();
			c1 = scan.nextInt();
			c2 = scan.nextInt();

			for (int i = c1 - 1; i <= c2 - 1; i++) {
				arr[r - 1][i] = 1;
			}

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0)
					count++;

			}
		}
		System.out.print(count);
	}

}
