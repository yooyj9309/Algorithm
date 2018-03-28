package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_Card_Counting {
	public static int[] getNeedCard(boolean a[][])
	{
		int value[]=new int[4];
		
		for(int i=0;i<4;i++)
		{
			int cnt=0;
			for(int j=0;j<13;j++)
			{
				if(!a[i][j])
					cnt++;
			}
			value[i]=cnt;
		}
		return value;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(in.readLine());
	
		for(int i=1;i<=n;i++)
		{
			boolean card[][]=new boolean[4][13];
			char tmp[]=in.readLine().toCharArray();
			boolean dup=false;
			String t=null;
			for(int j=0;j<tmp.length;j=j+3)
			{
				t=tmp[j+1]+""+tmp[j+2];
				if(tmp[j]=='S')
				{
					int m=Integer.parseInt(t);
					if(card[0][m])
					{
						dup=true;
						break;
					}
					else
						card[0][m]=true;
				}
				if(tmp[j]=='D')
				{
					int m=Integer.parseInt(t);
					if(card[1][m])
					{
						dup=true;
						break;
					}
					else
						card[1][m]=true;
				}
				if(tmp[j]=='H')
				{
					int m=Integer.parseInt(t);
					if(card[2][m])
					{
						dup=true;
						break;
					}
					else
						card[2][m]=true;
				}
				if(tmp[j]=='C')
				{
					int m=Integer.parseInt(t);
					if(card[3][m])
					{
						dup=true;
						break;
					}
					else
						card[3][m]=true;
				}
			}
			if(dup){
				System.out.println("#"+i+" "+"ERROR");
			}
			else
			{
				System.out.print("#"+i+" ");
				int value[]=getNeedCard(card);
				for(int c:value)
					System.out.print(c+" ");
				System.out.println();
			}
		}
	
	}

}
