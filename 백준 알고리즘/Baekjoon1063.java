package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1063 {
	static int kingX,kingY,stoneX,stoneY;
	public static boolean isIn(int x,int y)
	{
		boolean result=true;
		if(x>8||x<1||y>8||y<1)
			result=false;
		return result;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input[]=in.readLine().split(" ");
		
		kingX = (input[0].substring(0, 1).charAt(0) - 64);
		stoneX = (input[1].substring(0, 1).charAt(0) - 64);

		kingY = Integer.parseInt(input[0].substring(1, 2));
		stoneY = Integer.parseInt(input[1].substring(1, 2));
		
		int num=Integer.parseInt(input[2]);
		String index[]={"","A","B","C","D","E","F","G","H"};
		for(int i=0;i<num;i++)
		{
			String move=in.readLine();
			switch(move)
			{
			case "R":
				if(isIn(kingX+1,kingY))
				{
					if(kingX+1==stoneX&&kingY==stoneY)
					{
						if(isIn(stoneX+1,stoneY))
						{
							kingX++;
							stoneX++;
						}
					}
					else
						kingX++;
				}
				break;
			case "L":
				if(isIn(kingX-1,kingY))
				{
					if(kingX-1==stoneX&&kingY==stoneY)
					{
						if(isIn(stoneX-1,stoneY))
						{
							kingX--;
							stoneX--;
						}
					}
					else
						kingX--;
				}
				break;
			case "T":
				if(isIn(kingX,kingY+1))
				{
					if(kingY+1==stoneY&&kingX==stoneX)
					{
						if(isIn(stoneX,stoneY+1))
						{
							kingY++;
							stoneY++;
						}
					}
					else
						kingY++;
				}
				break;
			case "B":
				if(isIn(kingX,kingY-1))
				{
					if(kingY-1==stoneY&&kingX==stoneX)
					{
						if(isIn(stoneX,stoneY-1))
						{
							kingY--;
							stoneY--;
						}
					}
					else
						kingY--;
				}
				break;
			case "RT":
				if(isIn(kingX+1,kingY+1))
				{
					if(kingY+1==stoneY&&kingX+1==stoneX)
					{
						if(isIn(stoneX+1,stoneY+1))
						{
							kingY++;
							stoneY++;
							kingX++;
							stoneX++;
						}
					}
					else{
						kingX++;
						kingY++;
					}
				}
				break;
			case "RB":
				if(isIn(kingX+1,kingY-1))
				{
					if(kingY-1==stoneY&&kingX+1==stoneX)
					{
						if(isIn(stoneX+1,stoneY-1))
						{
							kingY--;
							stoneY--;
							kingX++;
							stoneX++;
						}
					}
					else{
						kingX++;
						kingY--;
					}
				}
				break;
			case "LT":
				if(isIn(kingX-1,kingY+1))
				{
					if(kingY+1==stoneY&&kingX-1==stoneX)
					{
						if(isIn(stoneX-1,stoneY+1))
						{
							kingY++;
							stoneY++;
							kingX--;
							stoneX--;
						}
					}
					else{
						kingX--;
						kingY++;
					}
				}
				break;
			case "LB":
				if(isIn(kingX-1,kingY-1))
				{
					if(kingY-1==stoneY&&kingX-1==stoneX)
					{
						if(isIn(stoneX-1,stoneY-1))
						{
							kingY--;
							stoneY--;
							kingX--;
							stoneX--;
						}
					}
					else{
						kingX--;
						kingY--;
					}
				}
				break;
			}
		}
		System.out.println(index[kingX]+kingY);
		System.out.println(index[stoneX]+stoneY);
	}

}
