package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Dice {
	int d[][] = new int[2][6];
	int x;
	int y;

	public Dice(int x, int y) {
		this.x = y;
		this.y = x;

	}
}

public class Baekjoon14499 {
	static int map[][] = null;
	static int n, m;

	public static Dice go1(Dice dice) {
		if (dice.x + 1 < m) {
			int temp = 0, temp1 = 0;
			temp = dice.d[0][0];
			temp1 = dice.d[1][0];
			dice.d[0][0] = dice.d[0][5];
			dice.d[1][0] = dice.d[1][5];
			dice.d[0][5] = dice.d[0][3];
			dice.d[1][5] = dice.d[1][3];
			dice.d[0][3] = dice.d[0][2];
			dice.d[1][3] = dice.d[1][2];
			dice.d[0][2] = temp;
			dice.d[1][2] = temp1;
			dice.x++;
			if (map[dice.y][dice.x] == 0)
				map[dice.y][dice.x] = dice.d[1][3];
			else {
				dice.d[1][3] = map[dice.y][dice.x];
				map[dice.y][dice.x] = 0;
			} 
			System.out.println(dice.d[1][0]);
		}
		return dice;
	}

	public static Dice go2(Dice dice) {
		if (dice.x - 1 >= 0) {
			int temp = 0, temp1 = 0;
			temp = dice.d[0][0];
			temp1 = dice.d[1][0];
			dice.d[0][0] = dice.d[0][2];
			dice.d[1][0] = dice.d[1][2];
			dice.d[0][2] = dice.d[0][3];
			dice.d[1][2] = dice.d[1][3];
			dice.d[0][3] = dice.d[0][5];
			dice.d[1][3] = dice.d[1][5];
			dice.d[0][5] = temp;
			dice.d[1][5] = temp1;
			dice.x--;
			if (map[dice.y][dice.x] == 0)
				map[dice.y][dice.x] = dice.d[1][3];
			else {
				dice.d[1][3] = map[dice.y][dice.x];
				map[dice.y][dice.x] = 0;
			}
			System.out.println(dice.d[1][0]);
		}
		return dice;
	}

	public static Dice go3(Dice dice) {
		if (dice.y - 1 >= 0) {
			int temp = 0, temp1 = 0;
			temp = dice.d[0][0];
			temp1 = dice.d[1][0];
			dice.d[0][0] = dice.d[0][1];
			dice.d[1][0] = dice.d[1][1];
			dice.d[0][1] = dice.d[0][3];
			dice.d[1][1] = dice.d[1][3];
			dice.d[0][3] = dice.d[0][4];
			dice.d[1][3] = dice.d[1][4];
			dice.d[0][4] = temp;
			dice.d[1][4] = temp1;
			dice.y--;
			if (map[dice.y][dice.x] == 0)
				map[dice.y][dice.x] = dice.d[1][3];
			else {
				dice.d[1][3] = map[dice.y][dice.x];
				map[dice.y][dice.x] = 0;
			}
			System.out.println(dice.d[1][0]);
		}
		return dice;
	}

	public static Dice go4(Dice dice) {
		if (dice.y + 1 < n) {
			int temp = 0, temp1 = 0;
			temp = dice.d[0][0];
			temp1 = dice.d[1][0];
			dice.d[0][0] = dice.d[0][4];
			dice.d[1][0] = dice.d[1][4];
			dice.d[0][4] = dice.d[0][3];
			dice.d[1][4] = dice.d[1][3];
			dice.d[0][3] = dice.d[0][1];
			dice.d[1][3] = dice.d[1][1];
			dice.d[0][1] = temp;
			dice.d[1][1] = temp1;
			dice.y++;
			if (map[dice.y][dice.x] == 0)
				map[dice.y][dice.x] = dice.d[1][3];
			else {
				dice.d[1][3] = map[dice.y][dice.x];
				map[dice.y][dice.x] = 0;
			}
			System.out.println(dice.d[1][0]);
		}
		return dice;
	}

	public static void show(Dice d) {
		System.out.println("x : " + d.x + " y : " + d.y);
		System.out.println("주사위 상태");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(d.d[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("주사위 밑바닥 :" + d.d[1][4]);
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input[] = in.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		int x = Integer.parseInt(input[2]);
		int y = Integer.parseInt(input[3]);
		int command = Integer.parseInt(input[4]);
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			input = in.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		int com[] = new int[command];
		input = in.readLine().split(" ");
		for (int i = 0; i < command; i++) {
			com[i] = Integer.parseInt(input[i]);
		}
		Dice dice = new Dice(x, y);

		for (int j = 0; j < 6; j++) {
			dice.d[0][j] = j;
		}
		for (int i = 0; i < command; i++) {
			switch (com[i]) {
			case 1:
				dice = go1(dice);
				break;
			case 2:
				dice = go2(dice);
				break;
			case 3:
				dice = go3(dice);
				break;
			case 4:
				dice = go4(dice);
				break;
			}

		}
	}

}
