import java.util.Arrays;
import java.util.Scanner;

public class Virus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inf=10000000;
		int n,e;
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		e=scan.nextInt();
		int dist[][]=new int [n][n];
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
					dist[i][j]=inf;
			}
		
		for(int i=0;i<e;i++)
		{
			int y=scan.nextInt();
			int x=scan.nextInt();
			
			dist[y-1][x-1]=dist[x-1][y-1]=1;
		}
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				for(int k=0;k<n;k++)
				{
					dist[j][k]=Math.min(dist[j][i]+dist[i][k],dist[j][k]);
				}

		int cnt=0;
		for(int i=1;i<n;i++)
		{
			if(dist[0][i]!=inf)
				cnt++;	
		}
		System.out.println(cnt);
	}

}
