package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon12100 {
	static int n = 0;
	static int map[][] = null;
	static boolean visit[] = new boolean[5];
	static int value[] = new int[5];
	static int max = 0;
	static int BLANK = 0;

	public static void dfs(int v, int len) {
		if (len == 5) {
			int tmp = move();
			if (max < tmp)
				max = tmp;
			return;
		}
		for (int i = 0; i < 4; i++) {
			value[len] = i;
			dfs(i, len + 1);
		}

	}

	public static int move() {
		int temp[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				temp[i][j] = map[i][j];
		}
		for (int i = 0; i < 5; i++) {
			switch (value[i]) {
			case 0:

				for (int row = 0; row < n; row++) {

					int nBlank = 0;
					// 왼쪽에서 오른쪽으로
					for (int col = 1; col < n; col++) {

						// 검사 노드 == 0
						if (temp[row][col] == BLANK) {

							nBlank++;
							continue;
						} else {

							// 병합 가능 : 검사 노드 = 대상 노드
							if (temp[row][col] == temp[row][col - 1 - nBlank]) {

								temp[row][col - 1 - nBlank] *= 2;
								temp[row][col] = BLANK;
							}
							// 병합 불가능 : 검사 노드 != 0 && 대상 노드 == 0
							else if (temp[row][col - 1 - nBlank] == 0) {

								temp[row][col - 1 - nBlank] = temp[row][col];
								temp[row][col] = BLANK;
								nBlank++;
							}
							// 병합 불가능 : 검사 노드 != 0 && 대상 노드 != 0 && 검사노드 != 대상노드
							else {

								temp[row][col - nBlank] = temp[row][col];
								if (nBlank != 0)
									temp[row][col] = BLANK;
							}
						}
					}
				}

				break;

			case 1:

				for (int col = 0; col < n; col++) {

					int nBlank = 0;
					// 위쪽에서 아래쪽으로
					for (int row = 1; row < n; row++) {

						// 검사 노드 == 0
						if (temp[row][col] == BLANK) {

							nBlank++;
							continue;
						} else {

							// 병합 가능 : 검사 노드 = 대상 노드
							if (temp[row - 1 - nBlank][col] == temp[row][col]) {

								temp[row - 1 - nBlank][col] *= 2;
								temp[row][col] = BLANK;
							}
							// 병합 불가능 : 검사 노드 != 0 && 대상 노드 == 0
							else if (temp[row - 1 - nBlank][col] == 0) {

								temp[row - 1 - nBlank][col] = temp[row][col];
								temp[row][col] = BLANK;
								nBlank++;
							}
							// 병합 불가능 : 검사 노드 != 0 && 대상 노드 == 0
							else {

								temp[row - nBlank][col] = temp[row][col];
								if (nBlank != 0)
									temp[row][col] = BLANK;
							}
						}
					}
				}
				break;

			case 2:

				for (int row = 0; row < n; row++) {

					int nBlank = 0;
					// 오른쪽에서 왼쪽으로
					for (int col = n - 2; col >= 0; col--) {

						// 검사 노드 == 0
						if (temp[row][col] == BLANK) {

							nBlank++;
							continue;
						} else {

							// 병합 가능 : 검사 노드 = 대상 노드
							if (temp[row][col] == temp[row][col + 1 + nBlank]) {

								temp[row][col + 1 + nBlank] *= 2;
								temp[row][col] = BLANK;
							}
							// 병합 불가능 : 검사 노드 != 0 && 대상 노드 == 0
							else if (temp[row][col + 1 + nBlank] == 0) {

								temp[row][col + 1 + nBlank] = temp[row][col];
								temp[row][col] = BLANK;
								nBlank++;
							}
							// 병합 불가능 : 검사 노드 != 0 && 대상 노드 == 0
							else {

								temp[row][col + nBlank] = temp[row][col];
								if (nBlank != 0)
									temp[row][col] = BLANK;
							}
						}
					}
				}
				break;

			case 3:

				for (int col = 0; col < n; col++) {

					int nBlank = 0;
					// 아래쪽에서 위쪽으로
					for (int row = n - 2; row >= 0; row--) {

						// 검사 노드 == 0
						if (temp[row][col] == BLANK) {

							nBlank++;
							continue;
						} else {

							// 병합 가능 : 검사 노드 = 대상 노드
							if (temp[row + 1 + nBlank][col] == temp[row][col]) {

								temp[row + 1 + nBlank][col] *= 2;
								temp[row][col] = BLANK;
							}
							// 병합 불가능 : 검사 노드 != 0 && 대상 노드 == 0
							else if (temp[row + 1 + nBlank][col] == 0) {

								temp[row + 1 + nBlank][col] = temp[row][col];
								temp[row][col] = BLANK;
								nBlank++;
							}
							// 병합 불가능 : 검사 노드 != 0 && 대상 노드 == 0
							else {

								temp[row + nBlank][col] = temp[row][col];
								if (nBlank != 0)
									temp[row][col] = BLANK;
							}
						}
					}
				}
				break;
			}

		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (max < temp[i][j])
					max = temp[i][j];
			}
		}
		return max;
	}

	public static void show(int tmp[][]) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		map = new int[n][n];
		String input[] = null;
		for (int i = 0; i < n; i++) {
			input = in.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		dfs(0, 0);
		System.out.println(max);
	}

}
