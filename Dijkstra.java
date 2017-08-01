
import java.util.*;

class Element implements Comparable<Element> {
	private int index;
	private int distance;

	Element(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}

	public int getIndex() {
		return index;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public int compareTo(Element o) {
		// TODO Auto-generated method stub
		return distance <= o.distance ? -1 : 1;
	}

}

public class Dijkstra {

	static int[] dist;
	static ArrayList<ArrayList<Integer>> ad = new ArrayList<ArrayList<Integer>>();
	static int nE, nV;
	static final int inf = 100000;

	public static void ssp(int start) {
		PriorityQueue<Element> q = new <Element>PriorityQueue();
		dist[start] = 0;
		q.offer(new Element(start, dist[start]));

		while (!q.isEmpty()) {
			int cost = q.peek().getDistance();
			int here = q.peek().getIndex();
			q.poll();

			if (cost > dist[here])
				continue;

			for (int i :ad.get(here)) {
				int node=i/11;
				int weight=i%11;
				
				if (dist[node] > dist[here] + weight) {
					dist[node] = dist[here] + weight;
					q.offer(new Element(node, dist[node]));
				}
			}

		}
		for (int i = 1; i <= nV; i++) {
			if (dist[i] == inf)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int start;

		nV = scan.nextInt();
		nE = scan.nextInt();
		start = scan.nextInt();
		dist = new int[nV + 1];

		for (int i = 0; i <= nV; i++) {
			dist[i] = inf;
			ad.add(new ArrayList<>());
		}
		
		for (int i = 0; i < nE; i++) {
			int t1 = scan.nextInt();
			int t2 = scan.nextInt();
			int t3 = scan.nextInt();

			ad.get(t1).add(t2*11+t3);

		}

		 ssp(start);

	}
}
