package SamsungExpert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * ��... �ùķ��̼� ���� ��¦ ������ ������ �ƴ϶� �׳� ���� �ڵ尡 �Ǿ���Ѵ�....
 * ������ : ������ ���� ��Ȯ�� �������� -> ��� �տ��� 1�� ��ٸ��⸦ �������� 1�� ��ٷ��� �򰥸� 
 * ��, ��� �������� ���� ��ٸ��� �͵�  �����ؾ��ϴµ� �װ� ���� �Ƚ��״�.
 * 
 * �׸��� ���� ����� �ȳ����� ������ �߻� -> �˰��� ��͸� ���鼭 �ʱ�ȭ�� ����� �ȵǴ� ���� Ȯ��(people)
 * �׷��� �ʱ�ȭ�� ���� -> ���⼭ �߿��Ѱ� �� �׳� people.clear()�ϰ� people.add(peoples.get(i))�ϸ� ���� 0 0 0 0 ������ �˾Ҵ�.
 * ������, get�̶�°� �ּҸ� �ִ� �ű� ������ people�� Ŭ���� �ȴ��ص� peoples�� �ִ� �ּҷ� ��� �����ϸ� ���� ��� ���� �ϰ� �־���.
 * �׷��� �ƿ� new�� �ʱ�ȭ�� ���ذ��� people�� add���־����� �ذ� -> init1()�Լ� �ڵ尡 ���� ������ ������ �ڵ�
 * 
 * */
class Person {
	int x;
	int y;
	int number;
	int arrTime;
	int finishTime;
	int waitingTime = 0;

	public Person(int y, int x, int number) {
		this.y = y;
		this.x = x;
		this.number = number;
	}

}

class Stair {
	int x;
	int y;
	boolean type;
	int size;

	public Stair(int y, int x, boolean type, int size) {
		this.y = y;
		this.x = x;
		this.type = type;
		this.size = size;
	}
}

public class SW_LunchTime {

	public static int n = 0;
	public static int map[][] = null;
	public static boolean visit[] = null;
	public static ArrayList<Person> people = null;
	public static ArrayList<Person> peoples = null;
	public static ArrayList<Stair> stair = null;
	public static int min = Integer.MAX_VALUE;

	public static void init()
	{
		people.clear();
		for(int i=0;i<peoples.size();i++)
		{
			Person t=peoples.get(i);
			Person tmp=new Person(t.y,t.x,t.number);
			tmp.arrTime=0;
			tmp.finishTime=0;
			tmp.waitingTime=0;
			people.add(tmp);
		}
	}
	public static void init1()
	{
		people.clear();
		for(int i=0;i<peoples.size();i++)
		{
			people.add(peoples.get(i));
		}
	}
	public static void dfs(int v, int len) {
		init();
		min = Math.min(situation(), min);
		for (int i = v + 1; i <= people.size(); i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(i, len + 1);
			}
		}

		visit[v] = false;
	}

	public static int situation() {
		int num1Stair = getSec(true, stair.get(0));
		int num2Stair = getSec(false, stair.get(1));

		int max = Math.max(num1Stair, num2Stair);
		return max;
	}

	public static int getSec(boolean type, Stair dest) {
		
		ArrayList<Person> pList = getPersons(type);
		Queue<Person> waitQ = new LinkedList<Person>();
		Person moveDown[] = new Person[3];
		int timer = 0;
		int cnt = 0;
		while (true) {
			for (int i = 0; i < 3; i++) {
				if (moveDown[i] != null) {
					if (moveDown[i].finishTime == timer) {
						moveDown[i] = null;
						cnt++;
					}
				}
			}
			if (cnt == pList.size())
				break;
			for (Person p : pList) {
				if (getDistance(dest, p) == timer) {
					waitQ.add(p);
				}
			}
			if (isFull(moveDown)) {
				if (!waitQ.isEmpty()) {
					for (Person a : waitQ)
						a.waitingTime++;
				}
			}

			for (int i = 0; i < 3; i++) {
				if (moveDown[i] == null) {
					if (!waitQ.isEmpty()) {
						Person p = waitQ.poll();
						if (p.waitingTime == 0)
							p.finishTime = timer + 1 + dest.size;
						else
							p.finishTime = timer + dest.size;
						moveDown[i] = p;
					}
				}
			}
			timer++;
		}
		return timer;
	}

	public static boolean isFull(Person moveDown[]) {
		boolean val = true;
		for (Person p : moveDown) {
			if (p == null) {
				val = false;
				break;
			}
		}
		return val;
	}

	public static Person[] allocate(int timer, Person move[]) {
		for (int i = 0; i < 3; i++) {
			if (move[i].finishTime == timer) {
				move[i] = null;
			}
		}
		return move;
	}

	public static ArrayList<Person> getPersons(boolean type) {
		ArrayList<Person> readyQ = new ArrayList<Person>();
		for (int i = 1; i < visit.length; i++) {
			if (visit[i] == type) {
				Person p = people.get(i - 1);
				readyQ.add(p);
			}
		}
		return readyQ;
	}

	public static int getDistance(Stair tempStair, Person p) {
		int sr = tempStair.y;
		int sc = tempStair.x;

		int pr = p.y;
		int pc = p.x;

		return Math.abs(pr - sr) + Math.abs(pc - sc);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int num = 1; num <= tc; num++) {
			n = sc.nextInt();
			map = new int[n][n];
			people = new ArrayList<Person>();
			peoples = new ArrayList<Person>();
			stair = new ArrayList<Stair>();
			int k = 1;
			boolean t = true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 1) {
						peoples.add(new Person(i, j, k));
						people.add(new Person(i, j, k));
						k++;
					} else if (map[i][j] > 1) {
						stair.add(new Stair(i, j, t, map[i][j]));
						t = false;
					}
				}
			}

			visit = new boolean[people.size() + 1];

			// visit[1]=true;
			// visit[2]=true;
			// visit[3]=true;
			// visit[5]=true;
			// System.out.println(situation());
			dfs(0, 0);
			System.out.println("#" + num + " " + min);
			min = Integer.MAX_VALUE;
		}
	}

}
