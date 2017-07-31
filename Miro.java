import java.util.Scanner;

public class Miro {
	static int map[][];
	static int n, m, min=Integer.MAX_VALUE;

	public static void dfs(int k, int j, int length) {

		if (k == n - 1 && j == m - 1) {
			if (min > length)
				min = length;
		}
		map[k][j] = 0;//지나 간길 다시 지나가지 않게

		if (j - 1 >= 0 && j - 1 < m)
			if (map[k][j - 1] == 1) {
				dfs(k, j - 1, length + 1);
			}
		if (j + 1 >= 0 && j + 1 < m)
			if (map[k][j + 1] == 1) {
				dfs(k, j + 1, length + 1);
			}
		if (k - 1 >= 0 && k - 1 < n)
			if (map[k - 1][j] == 1) {
				dfs(k - 1, j, length + 1);
			}
		if (k + 1 >= 0 && k + 1 < n)
			if (map[k + 1][j] == 1) {
				dfs(k + 1, j, length + 1);
			}
		map[k][j] = 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		m = scan.nextInt();

		map = new int[n][m];
		String nString = "";
        for (int i = 0; i < n; i++) {
            nString = scan.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(nString.charAt(j) + "");
            }
        }
		dfs(0,0,1);
		System.out.println(min);
	}

}
