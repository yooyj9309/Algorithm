package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1331 {
	static boolean[][] map;

	public static boolean isPossible(String first, String last) {
		int firstX = 0, firstY = 0, lastX = 0, lastY = 0;
	
		firstX = first.charAt(0) - '0' - 17;
		lastX = last.charAt(0) - '0' - 17;
		firstY = Integer.parseInt(first.charAt(1) + "") - 1;
		lastY = Integer.parseInt(last.charAt(1) + "") - 1;
		
		int cond1=Math.abs(firstX-lastX);
		int cond2=Math.abs(firstY-lastY);
		
		if((cond1==1&&cond2==2)||(cond1==2&&cond2==1)&&!map[lastX][lastY])
			return true;
		else 
			return false;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String ans = "Valid";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new boolean[6][6];
		for (int i = 0; i < 6; i++)
			Arrays.fill(map[i], false);

		String[] tmp = new String[36];
		for (int i = 0; i < 36; i++) 
			tmp[i] = in.readLine();
		
		for (int i = 1; i < 36; i++) 
		{
			int fX = 0, fY = 0, lX = 0, lY = 0;
			
			fX = tmp[i-1].charAt(0) - '0' - 17;
			lX = tmp[i].charAt(0) - '0' - 17;
			fY = Integer.parseInt(tmp[i-1].charAt(1) + "") - 1;
			lY = Integer.parseInt(tmp[i].charAt(1) + "") - 1;
			
			if(isPossible(tmp[i-1],tmp[i]))
				map[lX][lY]=true;
			else{
				ans="Invalid";
				break;
			}
		}
		int x = tmp[0].charAt(0) - '0' - 17;
		int y = Integer.parseInt(tmp[0].charAt(1) + "") - 1;
		if(isPossible(tmp[35],tmp[0]))
			map[x][y]=true;
		else
			ans="Invalid";
		int cnt=0;
		for(int i=0;i<6;i++)
			for(int j=0;j<6;j++)
			{
				if(map[i][j])
					cnt++;
			}
		if(cnt!=36)
			System.out.println("Invalid");
		else
			System.out.println("Valid");
	}

}
