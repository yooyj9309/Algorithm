package Algortihm2;
public class sadgds{
  
  // 그래프를 2차원 배열로 나타낼  수 있는데 그 의미는
  // 각 행(row)은 정점(vertex)을 나타내며
  // 열(column)은 그 행이 나타내는 정점에서 이어진 다른 정점까지의 가중치(값)을 나타낸다.
  // 행과 열이 같은 index를 가지는 곳(자기자신과 연결된다는 의미)은 값이 모두 0이며
  // 행과 열의 index가 다른 곳의 값이 0이라면 서로다른 정점간에 이어진 간선이 없다는 뜻이다.
  // 아래에서 첫번째 행을 예로 들자면
  // 첫째행(0번 정점)은 1번, 3번, 4번 정점과 이어져 있으며
  // 각각 그  가중치가 10, 30, 45라는 뜻이다.
  // 따라서 그래프를 2차원 배열로 나타낼 때
  // 좌상에서 우하( [0][0] , [n][n] )로 선을 그어서 접어본다면
  // 서로 대칭이 되는 것을 알 수 있다.

  static int[][] graph = {
      {0, 0, 0, 30, 45, 0}, 
      {0, 0, 50, 0, 40, 25}, 
      {0, 50, 0, 0, 35, 15}, 
      {30, 0, 0, 0, 0, 20}, 
      {45, 40, 35, 0, 0, 55}, 
      {0, 25, 15, 20, 55, 0} };
  
  static int n = graph.length;
  
  public static void main(String[] args) {

    int[] sv = new int[n];

    int count = 0;
    
    sv[count++] = 0; 
    boolean t=false;
   
    while(count < n) {
      int min = 100; 
      int from = 0;
      for (int i=0; i<count; i++) {
        // 그래프 배열의 한 행에 대해 가로로 진행하게 됨
        for (int j=0; j<n; j++) {
          // 선택된 정점과 이어진 다른 정점과의 값이 0이 아니고 (즉 이어져 값을 가지고 있고)
          // && 그 값이 최소값보다 작다면 (최소비용의 연결이라면)
          if ( graph[sv[i]][j] != 0 && graph[sv[i]][j] < min) {
            from = sv[i]; // 두 정점을 연결할 때 시작 정점.
            sv[count] = j; // 두 정점을 연결할 때 끝 정점.
            min = graph[sv[i]][j]; // 최소값 갱신
          }
          
        }
        
      }
     if (!isCycle(sv, sv[count], count)) { // cycle을 형성하지 않으면
        System.out.println(from + " --> " + sv[count]);
      } else { // cycle을 형성하면
        sv[count--] = 0; // 원래대로 환원
      }
     // 추가된 최소비용 간선을 제거한다.
     // 그래프 배열은 대칭구조이므로 row와 column의 index를 바꾸어 처리해 준다.
     graph[from][sv[count]] = 0;
     graph[sv[count]][from] = 0;
     count++; // sv의 index를 증가.
    } // end of while
  }

 

// 정점이 cycle을 이루게 되는지 알아본다.
  static boolean isCycle(int[] sv, int val, int cnt) {
    for (int i =0; i<cnt; i++) {
      if (sv[i] == val) {
        return true;
      }
    }
    return false;
  }

 

}


