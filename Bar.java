package Algortihm2;
import java.util.ArrayList;
import java.util.Scanner;

public class Bar {

	public static boolean isContains(int[] n,int num)
	{
		for(int i=0;i<7;i++)
		{
			if(n[i]==num)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();
		
		int[] list={1,2,4,8,16,32,64};
		
		if(isContains(list,num))
			System.out.println(1);
		else
		{
			int tmp=num;
			int cnt=0;
			
			for(int i=6;i>=0;i--)
			{
				
				if(tmp>=list[i])
				{
					cnt++;
					tmp-=list[i];
				}
			}
			System.out.println(cnt);
		}
	}

}
