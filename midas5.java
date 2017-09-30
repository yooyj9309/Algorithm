import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class SubwayNode implements Comparable<SubwayNode> {
	int s;
	int e;
	int v;

	public SubwayNode(int s, int e, int v) {
		
		super();
		this.s = s;
		this.e = e;
		this.v = v;
	}

	@Override
	public int compareTo(SubwayNode arg0) {
		return arg0.v >= this.v ? -1 : 1;
	}

}

public class midas5 {

	static int n;
	static int e;
	static PriorityQueue<SubwayNode> pq;
	static int[] parent_Node;
	static boolean[] visit;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String tmpInput[] = in.readLine().split(" ");
		String[] inputStr;
		
		n = Integer.valueOf(tmpInput[0]);
		e = Integer.valueOf(tmpInput[1]);
		pq = new PriorityQueue<SubwayNode>();
		parent_Node = new int[n + 1];
		visit = new boolean[n + 1];
		result = 0;

		for (int i = 0; i < e; i++) {
			inputStr = in.readLine().split(" ");
			pq.add(new SubwayNode(Integer.valueOf(inputStr[0]), Integer.valueOf(inputStr[1]), Integer.valueOf(inputStr[2])));
		}

		for (int i = 1; i <= n; i++) {
			parent_Node[i] = i;
		}

		for (int i = 0; i < e; i++) {
			SubwayNode oneNode = pq.poll();
			int start = oneNode.s;
			int end = oneNode.e;
			
			int a = find(start);
			int b = find(end);
			
			if (a == b)
				continue;

			sum(start, end);
			result += oneNode.v;
		}
		for(int i=1;i<=n;i++)
		{
			if(!visit[i])
			{
				result=-1;
			}
		}
		
		System.out.println(result);
	}

	public static int find(int a) {
		visit[a]=true;
		if (a == parent_Node[a])
			return a;
		parent_Node[a] = find(parent_Node[a]);
		return parent_Node[a];
	}

	public static void sum(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA != rootB) {
			parent_Node[rootA] = b;
		} else {
			return;
		}
	}

}
