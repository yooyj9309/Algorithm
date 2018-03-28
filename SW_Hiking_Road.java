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
 * Ǯ� �Ұ�: ��� Ǫ������ �ݹ� �˾Ҵ�. ������ ����뿡�� �ð��� ��û ���� ��� ���� �Ф�
 * dfs�� ���� �������� ��������� �Լ��� �Ҹ���.
 * ���⼭ ���� �Ǽ��ߴ� ���� isCheck=true ��� �ڵ�� �� ù��° ������ �÷��׸� true�� �������� ���ȵ�
 * �׷��� ���������� �������� �� �� �ڵ尡 true�� ���� ���ѹ��ȱ� ������ ��Ʈ��ŷ�ؼ� ó������ �ٽ� ���ƿ͵� true
 * �ذ��� : �Ű������� !isCheck�� �ٲپ �ذ�, �� ù��° ���ÿ� �ִ� ��� �Լ��� ���� ������ �ʰ� ��� false ����
 * �׷��Ƿ� ��Ʈ��ŷ�ؼ� ���ƿ��� ���� �ٽ� �ٸ� �������� ��ȸ�� ����������
 * 
 * ������ : ������ ��� ����� ����, ����� �� �� ������ �����ʿ� �ִµ� ���� �Ķ���� ������ ���鼭 ��ġ��
 * */