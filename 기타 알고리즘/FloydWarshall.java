import java.util.Scanner;

public class FloydWarshall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inf=10000000;
		int n;
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		int dist[][]=new int [n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				dist[i][j]=scan.nextInt();
				if(dist[i][j]==0)
					dist[i][j]=inf;
			}
		
		for(int i=0;i<n;i++)//경유하는 노드를 의미
			for(int j=0;j<n;j++)// 시작 노드를 의미    (시작노드 -> 끝노드)
				for(int k=0;k<n;k++)// 끝 노드를 의미
				{
					dist[j][k]=Math.min(dist[j][i]+dist[i][k],dist[j][k]);
				}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
			{
				if(dist[i][j]==inf)
					System.out.print(0+ " ");
				else
					System.out.print(1+ " ");
			}
			System.out.println();
		}
	}

}
