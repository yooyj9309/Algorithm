import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SoombaKKokjil {

	static Queue<Integer> queue = new LinkedList<Integer>();
	static int visit[] = new int[100001];

	public static void bfs(int start, int end) {
		Arrays.fill(visit, 0);
		int v, result = 0;
		queue.add(start);
		visit[start] = 1;

		while (!queue.isEmpty()) {
			v = queue.poll();

			if (end == v) {
				result=visit[v]-1;
				break;
			}
			
			if(v-1>=0){
			if (visit[v - 1] == 0) {
				visit[v - 1] = visit[v] + 1;
				queue.add(v - 1);
			}
			}
			if (v + 1 <= 100000 && visit[v + 1] == 0) {
				visit[v + 1] = visit[v] + 1;
				queue.add(v + 1);
			}
			if (v * 2 <= 100000 && visit[v * 2] == 0) {
				visit[v * 2] = visit[v] + 1;
				queue.add(v * 2);
			}

		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();

		bfs(num1, num2);
	}

}
