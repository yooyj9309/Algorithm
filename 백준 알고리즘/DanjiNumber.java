import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Ascending implements Comparator<Integer> {
	 
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		 return o1.compareTo(o2);
	}
}

public class DanjiNumber {
	static int map[][];
	static Queue<Integer> q=new LinkedList<Integer>();
	static ArrayList<Integer> cntArr=new ArrayList<Integer>();
	
	public static int bfs(int n, int m) {
		
		int cnt=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
			{
				if(map[i][j]==1)//start
				{
					int count=1;
					map[i][j] =0;
					q.add(i*m+j);
					while (!q.isEmpty()) {
						int y = q.peek() / m;
						int x = q.peek() % m;
						
						q.poll();

						if (x - 1 >= 0 && x - 1 < m)
							if (map[y][x - 1] == 1 ) {
								count++;
								map[y][x-1] =0;
								q.add(y * m + x - 1);
							}
						if (x + 1 >= 0 && x + 1 < m)
							if (map[y][x + 1] == 1) {
								map[y][x+1] =0;
								count++;
								q.add(y * m + x + 1);
							}
						if (y - 1 >= 0 && y - 1 < n)
							if (map[y - 1][x] == 1 ) {
								map[y-1][x] =0;
								count++;
								q.add((y - 1) * m + x);
							}
						if (y + 1 >= 0 && y + 1 < n)
							if (map[y + 1][x] == 1) {
								map[y+1][x] =0;
								count++;
								q.add((y + 1) * m + x);
							}
					}
					cnt++;
					cntArr.add(count);
				}
			}
		return cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n;
		n = scan.nextInt();

		map = new int[n][n];
		String nString = "";
		for (int i = 0; i < n; i++) {
			nString = scan.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(nString.charAt(j) + "");
			}
		}
		System.out.println(bfs(n,n));
		Collections.sort(cntArr,new Ascending());
		for(Integer a:cntArr)
			System.out.println(a);
	}

}
