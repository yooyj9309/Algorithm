package Algortihm2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Baekjoon15651 {
	static int n,m;
	static BufferedWriter bf=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void dfs(int len,int arr[]) throws IOException
	{
		if(len==m)
		{
			for(int a:arr)
				bf.write(a+" ");
			bf.newLine();
			bf.flush();
		}
		else{
			for(int i=1;i<=n;i++){
				arr[len]=i;
				dfs(len+1,arr);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int arr[]=new int[m];
		dfs(0,arr);
	}

}
