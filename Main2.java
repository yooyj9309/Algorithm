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
		System.out.println("시작점은 "+start);
		queue[rear++]=start;
		while(front<rear)//프론트랑 레어랑 같아질때 -> 모든 노드를 방문한것과 같음
		{
			v=queue[front++];//v는 현재 노드라고 생각하자
			for(int i=0;i<30;i++){
				if(map[v][i]==1&&visit[v]!=1)
				{
					visit[i]=1;//i는 현재 노드에서 다음으로 움직인노드이다.
					queue[rear++]=i;
				}
			}
		}
		
	}
	
}
