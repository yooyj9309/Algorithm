import java.util.Scanner;

public class Main2 {
	
	static int visit[]= new int[30];
	static int queue[]= new int[30];
	static int map[][]=new int[30][30];
	static int front=0,rear=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		for(int i=0;i<30;i++){
			visit[i]=0;
			for(int j=0;j<30;j++)
			{
				map[i][j]=0;
			}
		}//initialize
		
		while(true){
			int vt1=scan.nextInt();
			int vt2=scan.nextInt();
			
			if(vt1==-1||vt2==-1)
				break;
			map[vt1][vt2]=map[vt2][vt1]=1;
		}
		bfs(1);
	}
	public static void bfs(int start){
		int v;
		v=start;
		visit[start]=1;
		System.out.println("�������� "+start);
		queue[rear++]=start;
		while(front<rear)//����Ʈ�� ����� �������� -> ��� ��带 �湮�ѰͰ� ����
		{
			v=queue[front++];//v�� ���� ����� ��������
			for(int i=0;i<30;i++){
				if(map[v][i]==1&&visit[v]!=1)
				{
					visit[i]=1;//i�� ���� ��忡�� �������� �����γ���̴�.
					queue[rear++]=i;
				}
			}
		}
		
	}
	
}
