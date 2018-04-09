package SamsungExpert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Magnetic {
	LinkedList<Integer> nal = new LinkedList<Integer>();
	int dir = 0;

	public void rotate() {
		if (this.dir == 1) {
			int tmp = this.nal.removeLast();
			this.nal.addFirst(tmp);
		} else if (this.dir == -1) {
			int tmp = this.nal.removeFirst();
			this.nal.addLast(tmp);
		}

	}
}

public class SW_Magnetic {
	static int k = 0;
	static Magnetic mag[] = new Magnetic[4];
	static boolean visit[] = null;

	public static void bfs(int num) {
		visit=new boolean[4];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		while (!q.isEmpty()) {
			int t = q.poll();
			visit[t] = true;
			if (t - 1 >= 0) {
				if (!visit[t - 1]) {
					if (mag[t].nal.get(6) != mag[t - 1].nal.get(2)) {
						mag[t - 1].dir = mag[t].dir * -1;
						q.add(t - 1);
					}
				}
			}
			if (t + 1 <= 3) {
				if (!visit[t + 1]) {
					if (mag[t].nal.get(2) != mag[t + 1].nal.get(6)) {
						mag[t + 1].dir = mag[t].dir * -1;
						q.add(t + 1);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int num = 1; num <= tc; num++) {
			k = sc.nextInt();
			for (int i = 0; i < 4; i++) {
				mag[i] = new Magnetic();
				for (int j = 0; j < 8; j++)
				{
					int tmp = sc.nextInt();
					mag[i].nal.add(tmp);
				}
			}
			for (int i = 0; i < k; i++) {
				int magNum = sc.nextInt() - 1;
				int direction = sc.nextInt();
				
				mag[magNum].dir =direction;
				bfs(magNum);
				
				for(int j=0;j<4;j++)
				{
					mag[j].rotate();
					mag[j].dir=0;// 이 문장이 없어 bug가 생김-> 코드도 이분탐색 하자 이거 좋은 거 같다 
				}
			}
			
			int sum=0;
			sum=mag[0].nal.get(0)*1+mag[1].nal.get(0)*2+mag[2].nal.get(0)*4+mag[3].nal.get(0)*8;
			
			System.out.println("#"+num+" "+sum);
		}
	}

}
