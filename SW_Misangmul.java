package SamsungExpert;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * 느낀점 : 어떻게 짜야될지 구성은 빠르게 정할 수 있는 것 같다. 하지만 실제 코드 구현에 있어서 항상 오류가 있다. 
 * merge 부분을 구현할때 for두개를 써서 구현했는 데 3개가 동시에 하나일때 방향 값이 이상하게 들어오는게 문제가 있엇다(여기서 1시간 넘게 시간 걸림)
 * 그리고 갑자기 메모리 문제가 발생했다. 알고보니 processMedicine 부분에서 break를 걸어 리스트의 다른 요소들을 점검할 수 없었던것이 화근이였다.
 * 반성하자. 그리고 집중만 한다하지말고 설계를 정말 완벽하게 해보자.
 * */
class Node {
	int x;
	int y;
	int num;
	int direction;

	Node(int y, int x) {
		this.y = y;
		this.x = x;
	}

	Node(int y, int x, int num, int direction) {
		this.y = y;
		this.x = x;
		this.num = num;
		this.direction = direction;
	}
}

public class SW_Misangmul {
	public static int n = 0;
	public static int m = 0;
	public static int k = 0;
	public static ArrayList<Node> list = new ArrayList<Node>();
	public static int sum[][] = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int num = 1; num <= tc; num++) {
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();

			for (int knum = 0; knum < k; knum++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				int number = sc.nextInt();
				int dir = sc.nextInt();

				list.add(new Node(y, x, number, dir));
			}
			int timer = 0;

			while (timer < m) {
				move();
				processMedicine();
				list = merge();
				timer++;
			}
			int sum = 0;
			for (Node node : list) {
				sum += node.num;
			}
			System.out.println("#" + num + " " + sum);
			list.clear();
		}
	}

	public static void move() {
		for (Node n : list) {
			switch (n.direction) {
			case 1:
				n.y--;
				break;
			case 2:
				n.y++;
				break;
			case 3:
				n.x--;
				break;
			case 4:
				n.x++;
				break;
			}
		}
	}

	public static void processMedicine() {
		ArrayList<Node> tmp = new ArrayList<Node>();
		for (Node n1 : list) {
			if (n1.x == 0 || n1.y == 0 || n1.x == n - 1 || n1.y == n - 1) {
				if (n1.num == 1) {
					tmp.add(n1);
				} else {
					n1.num = n1.num / 2;
					n1.direction = rotate(n1);
				}
			}
		}

		for (Node n2 : tmp)
			list.remove(n2);
	}

	public static int rotate(Node n) {
		int ans = 0;
		switch (n.direction) {
		case 1:
			ans = 2;
			break;
		case 2:
			ans = 1;
			break;
		case 3:
			ans = 4;
			break;
		case 4:
			ans = 3;
			break;
		}
		return ans;
	}

	public static ArrayList<Node> merge() {
		int size = list.size();
		ArrayList<Node> tmp = new ArrayList<Node>();

		Node map1[][] = new Node[n][n];
		sum = new int[n][n];

		for (int i = 0; i < size; i++) {
			Node n1 = list.get(i);
			int y = n1.y;
			int x = n1.x;

			if (map1[y][x] == null) {
				map1[y][x] = n1;
				sum[y][x] += map1[y][x].num;
			} else {
				if (map1[y][x].num < n1.num) {
					sum[y][x] += n1.num;
					map1[y][x] = n1;
				} else {
					sum[y][x] += n1.num;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map1[i][j] != null) {
					map1[i][j].num = sum[i][j];
					tmp.add(map1[i][j]);
				}
			}
		}
		return tmp;
	}

}
