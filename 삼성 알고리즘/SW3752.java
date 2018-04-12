package SamsungExpert;
import java.util.Scanner;

public class SW3752 {
	static int n = 0;
	static int score[] = null;
	static boolean getScore[] = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int num = 1; num <= tc; num++) {
			n = sc.nextInt();
			score = new int[n];

			for (int i = 0; i < n; i++){
				score[i] = sc.nextInt();
			}


			getScore = new boolean[10001];
			getScore[0]=true;
			for(int i=0;i<score.length;i++)
			{
				for(int j=10000;j>=0;j--)
				{
					if(getScore[j])
					{
						getScore[j+score[i]]=true;
					}
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < getScore.length; i++) {
				if (getScore[i]) {
					cnt++;
				}
			}
			System.out.println("#" + num + " " + cnt);
		}
	}

}
