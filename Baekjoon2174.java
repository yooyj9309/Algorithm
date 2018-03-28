package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Robot {
	int x, y, id;
	String cur;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCur() {
		return cur;
	}

	public void setCur(String cur) {
		this.cur = cur;
	}

	public Robot(int x, int y, int id, String cur) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.cur = cur;
	}

}

public class Baekjoon2174 {
	static boolean map[][];
	static String[] dir = { "N", "E", "S", "W" };
	static int a = 0, b = 0, n = 0;
	static Robot[] robot;

	public static String move(String m, Robot r) {
		String err = "OK";

		switch (m) {
		case "L":
			L(r);
			break;
		case "R":
			R(r);
			break;
		case "F":
			err = F(r);
			break;
		default:
			break;
		}
		return err;
	}

	public static void L(Robot r) {
		if (dir[0].equals( r.cur)) {
			r.setCur(dir[3]);
		} else {
			for (int i = 1; i < 4; i++) {
				if (dir[i].equals(r.cur)) {
					r.setCur(dir[i - 1]);
					break;
				}
			}
		}
	}

	public static void R(Robot r) {
		for (int i = 0; i < 4; i++) {
			if (dir[3].equals(r.cur)) {
				r.setCur(dir[0]);
				break;
			} else if (dir[i].equals(r.cur)) {
				r.setCur(dir[i + 1]);
				break;
			}
		}
	}

	public static int findId(int y, int x) {
		int id = 0;
		for (int i = 0; i < n; i++) {
			if (robot[i].x == x && robot[i].y == y) {
				id = robot[i].id;
				break;
			}
		}
		return id;
	}

	public static String F(Robot r) {
		String err1 = "OK";

		switch (r.cur) {
		case "N":
			map[r.y][r.x] = false;
			if (r.y + 1 >= 0 && r.y + 1 < b && !map[r.y + 1][r.x]) {
				r.y += 1;
				map[r.y][r.x] = true;
			} else if (r.y + 1 < 0 || r.y + 1 >= b)
				err1 = "Robot " + r.id + " crashes into the wall";
			else if (map[r.y + 1][r.x]) {
				err1 = "Robot " + r.id + " crashes into robot " + findId(r.y + 1, r.x);
			}
			break;
		case "E":
			map[r.y][r.x] = false;
			if (r.x + 1 >= 0 && r.x + 1 < a && !map[r.y][r.x + 1]) {
				r.x += 1;
				map[r.y][r.x] = true;
			} else if (r.x + 1 < 0 || r.x + 1 >= a)
				err1 = "Robot " + r.id + " crashes into the wall";
			else if (map[r.y][r.x + 1]) {
				err1 = "Robot " + r.id + " crashes into robot " + findId(r.y, r.x + 1);
			}
			break;
		case "W":
			map[r.y][r.x] = false;

			if (r.x - 1 >= 0 && r.x - 1 < a && !map[r.y][r.x - 1]) {
				r.x -= 1;
				map[r.y][r.x] = true;
			} else if (r.x - 1 < 0 || r.x - 1 >= a)
				err1 = "Robot " + r.id + " crashes into the wall";
			else if (map[r.y][r.x - 1]) {
				err1 = "Robot " + r.id + " crashes into robot " + findId(r.y, r.x - 1);
			}
			break;
		case "S":
			map[r.y][r.x] = false;
			if (r.y - 1 >= 0 && r.y - 1 < b && !map[r.y - 1][r.x]) {
				r.y -= 1;
				map[r.y][r.x] = true;
			} else if (r.y - 1 < 0 || r.y - 1 >= b)
				err1 = "Robot " + r.id + " crashes into the wall";
			else if (map[r.y - 1][r.x]) {
				err1 = "Robot " + r.id + " crashes into robot " + findId(r.y - 1, r.x);
			}
			break;
		}
		return err1;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] ab = in.readLine().split(" ");
		a = Integer.parseInt(ab[0]);
		b = Integer.parseInt(ab[1]);

		map = new boolean[b][a];

		for (int i = 0; i < b; i++)
			Arrays.fill(map[i], false);

		String[] nm = in.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);

		robot = new Robot[n];

		for (int i = 0; i < n; i++) {
			String[] r = in.readLine().split(" ");
			int x = Integer.parseInt(r[0]) - 1;
			int y = Integer.parseInt(r[1]) - 1;
			map[y][x] = true;

			robot[i] = new Robot(x, y, i + 1, r[2]);
		}
		String ok = "OK";
		for (int i = 0; i < m; i++) {
			String[] r = in.readLine().split(" ");
			int id = Integer.parseInt(r[0]) - 1;
			String m1 = r[1];
			int num = Integer.parseInt(r[2]);
			int j = 0;
			for (j = 0; j < num; j++) {
				String ans = move(m1, robot[id]);
				if (!ok.equals(ans)) {
					ok = ans;
					break;
				}
			}
			if (j != num)
				break;

		}
		System.out.println(ok);
	}

}
