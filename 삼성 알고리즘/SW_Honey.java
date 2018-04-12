package SamsungExpert;
import java.util.Scanner;
/*
 * 함부로 이프문을 길게 하지 말자,......
 * */
public class SW_Honey {
	public static int n = 0;
	public static int m = 0;
	public static int c = 0;
	public static int map[][] = null;
	public static boolean visit1[] = null;
	public static int maxValue = 0;
	public static int realMax = 0;

	public static void getPair(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = i + 1; j <= size; j++) {
				if (isPossible(i,j))
					realMax = Math.max(realMax, getMaxHoney(i, j));
			}
		}
	}
	public static boolean isPossible(int n1, int n2)
	{
		boolean val=true;
		int s=n-m+1;
		boolean [][] check=new boolean[n][n];
		
		int n1y=0,n2y=0;
		
		if (n1 % s == 0)
			n1y = (n1 / s) - 1;
		else
			n1y = (n1 / s);
		int n1x=n1-s*n1y-1;
		
		if (n2 % s == 0)
			n2y = (n2 / s) - 1;
		else
			n2y = (n2 / s);
		int n2x=n2-s*n2y-1;
				
		for(int i=0;i<m;i++)
			check[n1y][n1x+i]=true;
		
		
		for(int i=0;i<m;i++)
		{
			if(check[n2y][n2x+i])
			{
				val=false;
				break;
			}
		}
		return val;
	}
	public static int getMaxHoney(int i, int j) {
		int firstList[] = getHoneyContainers(i, j)[0];
		int secondList[] = getHoneyContainers(i, j)[1];
		
		maxValue = 0;
		getMaxHoneyInContainers(0, firstList, 0, 0);
		int max1 = maxValue;
		
		maxValue = 0;
		getMaxHoneyInContainers(0, secondList, 0, 0);
		int max2 = maxValue;

		return max1 + max2;
	}
	public static void getMaxHoneyInContainers(int v, int arr[], int sum, int sum_dup) {
		if (sum <= c) {
			maxValue = Math.max(maxValue, sum_dup);
		}
		visit1[v] = true;
		for (int i = v + 1; i < visit1.length; i++) {
			if (!visit1[i]) {
				getMaxHoneyInContainers(i, arr, sum + arr[i - 1], sum_dup + (arr[i - 1] * arr[i - 1]));
			}
		}

		visit1[v] = false;
	}
	public static int[][] getHoneyContainers(int im, int j) {
		int[][] container = new int[2][m];

		int num[] = new int[2];
		num[0] = im;
		num[1] = j;

		for (int k = 0; k < 2; k++) {
			int y = 0;

			if (num[k] % (n - m + 1) == 0)
				y = (num[k] / (n - m + 1)) - 1;
			else
				y = (num[k] / (n - m + 1));

			int x = num[k] - (n - m + 1) * y - 1;

			for (int i = 0; i < m; i++) {
				container[k][i] = map[y][x];
				x++;
			}
		}
		return container;
	}

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int num = 1; num <= tc; num++) {
			n = sc.nextInt();
			m = sc.nextInt();
			c = sc.nextInt();
			int size = n * (n - m + 1);
			visit1 = new boolean[m + 1];

			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			//System.out.println(isPossible(1,3));
			getPair(size);
			System.out.println("#" + num + " " + realMax);
			realMax = 0;

		}
	}

}
