import java.util.Scanner;

public class Main2 {

	static int visit[];
	static int visit1[];
	static int queue[];
	static int map[][];
	static int front=0,rear=0;
	static boolean ctrl=true;
	
	public static void init(int node)
	{
		//오늘의 문제: visit 변수에 1이 아닌 234 값이 들어감(++연산도 없고 =1밖에 없는데)
		//이유: visit=queue=new int[node]; 이 ㅈㄹ을 해놓고 코딩을 함......
		//당연히 같은 주소를 받으니까 큐를 건들때마다 visit도 변화가 됨..(이거 찾느라 2시간 반....)
		queue=new int[node];
		visit=new int[node];
		
		visit1=new int[node];
		map=new int [node][node];
		for(int i=0;i<node;i++){
			visit[i]=0;
			visit1[i]=0;
			for(int j=0;j<node;j++)
			{
				map[i][j]=0;
			}
		}//initialize		
	}
	public static void bfs(int start,int node){
		int v;
		v=start-1;
		visit[v]=1;
		System.out.println(start);
		queue[rear++]=v;
		while(front<rear)//프론트랑 레어랑 같아질때 -> 모든 노드를 방문한것과 같음
		{
			v=queue[front++];//v는 현재 노드라고 생각하자
			for(int i=0;i<node;i++){
				
				if(map[v][i]==1&&visit[i]!=1)
				{
					visit[i]=1;//i는 현재 노드에서 다음으로 움직인노드이다.
					System.out.println(i+1);
					queue[rear++]=i;
				}
			}
		}
		
	}
	public static void dfs(int start,int node)
	{
		int v=start-1;
		visit1[v]=1;
		if(ctrl){
			System.out.println(start);
			ctrl=false;
		}
		for(int i=0;i<node;i++)
		{
			if(map[v][i]==1&&visit1[i]!=1){
				System.out.println(i+1);
				dfs(i+1,node);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Node?");
		int node=scan.nextInt();
		System.out.println("Edge?");
		int edge=scan.nextInt();
		System.out.println("Start?");
		int start=scan.nextInt();
		
		int vt1,vt2;
		init(node);
		
		for(int i=0;i<edge;i++){
			System.out.println("Two number?"+i);
			vt1=scan.nextInt();
			vt2=scan.nextInt();

			map[vt1-1][vt2-1]=map[vt2-1][vt1-1]=1;
		}
		bfs(start,node);
		dfs(start,node);
	}	
}
