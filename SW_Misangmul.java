package SamsungExpert;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * ������ : ��� ¥�ߵ��� ������ ������ ���� �� �ִ� �� ����. ������ ���� �ڵ� ������ �־ �׻� ������ �ִ�. 
 * merge �κ��� �����Ҷ� for�ΰ��� �Ἥ �����ߴ� �� 3���� ���ÿ� �ϳ��϶� ���� ���� �̻��ϰ� �����°� ������ �־���(���⼭ 1�ð� �Ѱ� �ð� �ɸ�)
 * �׸��� ���ڱ� �޸� ������ �߻��ߴ�. �˰��� processMedicine �κп��� break�� �ɾ� ����Ʈ�� �ٸ� ��ҵ��� ������ �� ���������� ȭ���̿���.
 * �ݼ�����. �׸��� ���߸� �Ѵ��������� ���踦 ���� �Ϻ��ϰ� �غ���.
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
