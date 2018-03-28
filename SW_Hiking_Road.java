package SamsungExpert;

import java.util.Scanner;

public class SW_Hiking_Road {

	static int map[][]=null;
	static boolean visit[][]=null;
	static int n=0,l=0;
	static int ax[]={0,1,0,-1};
	static int ay[]={1,0,-1,0};
	static int max=0;
	public static void dfs(int val, int y,int x,boolean isCheck, int len)
	{
		int nx=0,ny=0;
		visit[y][x]=true;
		
		for(int k=0;k<4;k++)
		{
			nx=x+ax[k];
			ny=y+ay[k];
			
			if(0<=nx&&nx<n&&0<=ny&&ny<n)
			{
				if(map[ny][nx]>=val&&!visit[ny][nx])
				{
					if(!isCheck){
						if(map[ny][nx]==val){
							dfs(map[ny][nx]-1,ny,nx,!isCheck,len+1);
						}
						else if(map[ny][nx]-val<l)
						{
							int tmp=map[ny][nx]-val+1;
							dfs(map[ny][nx]-tmp,ny,nx,!isCheck,len+1);
						}
						else{
							max=Math.max(max, len);
						}
					}
					else
					{
						max=Math.max(max, len);
					}
				}
			}
		}
	
	
		for(int k=0;k<4;k++)
		{
			nx=x+ax[k];
			ny=y+ay[k];
			
			if(0<=nx&&nx<n&&0<=ny&&ny<n)
			{
				if(map[ny][nx]<val&&!visit[ny][nx])
				{
					dfs(map[ny][nx],ny,nx,isCheck,len+1);
				}
			}
		}
	
		visit[y][x]=false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int tc=scan.nextInt();
		for(int num=1;num<=tc;num++)
		{
			n=scan.nextInt();
			l=scan.nextInt();
			
			map=new int[n][n];
			visit=new boolean[n][n];
			int maxHeight=0;
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					int tmp=scan.nextInt();
					if(maxHeight<tmp)
						maxHeight=tmp;
					map[i][j]=tmp;
				}
			}
			
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					if(map[i][j]==maxHeight)
					{
						dfs(map[i][j],i,j,false,1);
					}
					
				}
			}
			System.out.println("#"+num+" "+max);
			max=0;
		}
		
	}

}
/*
 * 풀어본 소감: 어떻게 푸는지는 금방 알았다. 하지만 디버깅에서 시간이 엄청 많이 잡아 먹음 ㅠㅠ
 * dfs는 스택 형식으로 재귀적으로 함수가 불린다.
 * 여기서 내가 실수했던 점은 isCheck=true 라는 코드로 맨 첫번째 스택의 플래그를 true로 고정시켜 버렸따
 * 그래서 오른쪽으로 움직였을 때 위 코드가 true로 고정 시켜버렸기 때문에 백트랙킹해서 처음으로 다시 돌아와도 true
 * 해결방법 : 매개변수로 !isCheck로 바꾸어서 해결, 즉 첫번째 스택에 있는 재귀 함수는 값이 변하지 않고 계속 false 상태
 * 그러므로 백트랙킹해서 돌아오고 나면 다시 다른 방향으로 순회가 가능해진다
 * 
 * 느낀점 : 스택형 사고 방식을 하자, 디버깅 할 때 스택이 오른쪽에 있는데 스택 파라미터 값들을 보면서 고치자
 * */