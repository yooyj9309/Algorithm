package Algortihm2;
public class sadgds{
  
  // �׷����� 2���� �迭�� ��Ÿ��  �� �ִµ� �� �ǹ̴�
  // �� ��(row)�� ����(vertex)�� ��Ÿ����
  // ��(column)�� �� ���� ��Ÿ���� �������� �̾��� �ٸ� ���������� ����ġ(��)�� ��Ÿ����.
  // ��� ���� ���� index�� ������ ��(�ڱ��ڽŰ� ����ȴٴ� �ǹ�)�� ���� ��� 0�̸�
  // ��� ���� index�� �ٸ� ���� ���� 0�̶�� ���δٸ� �������� �̾��� ������ ���ٴ� ���̴�.
  // �Ʒ����� ù��° ���� ���� ���ڸ�
  // ù°��(0�� ����)�� 1��, 3��, 4�� ������ �̾��� ������
  // ���� ��  ����ġ�� 10, 30, 45��� ���̴�.
  // ���� �׷����� 2���� �迭�� ��Ÿ�� ��
  // �»󿡼� ����( [0][0] , [n][n] )�� ���� �׾ ����ٸ�
  // ���� ��Ī�� �Ǵ� ���� �� �� �ִ�.

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
        // �׷��� �迭�� �� �࿡ ���� ���η� �����ϰ� ��
        for (int j=0; j<n; j++) {
          // ���õ� ������ �̾��� �ٸ� �������� ���� 0�� �ƴϰ� (�� �̾��� ���� ������ �ְ�)
          // && �� ���� �ּҰ����� �۴ٸ� (�ּҺ���� �����̶��)
          if ( graph[sv[i]][j] != 0 && graph[sv[i]][j] < min) {
            from = sv[i]; // �� ������ ������ �� ���� ����.
            sv[count] = j; // �� ������ ������ �� �� ����.
            min = graph[sv[i]][j]; // �ּҰ� ����
          }
          
        }
        
      }
     if (!isCycle(sv, sv[count], count)) { // cycle�� �������� ������
        System.out.println(from + " --> " + sv[count]);
      } else { // cycle�� �����ϸ�
        sv[count--] = 0; // ������� ȯ��
      }
     // �߰��� �ּҺ�� ������ �����Ѵ�.
     // �׷��� �迭�� ��Ī�����̹Ƿ� row�� column�� index�� �ٲپ� ó���� �ش�.
     graph[from][sv[count]] = 0;
     graph[sv[count]][from] = 0;
     count++; // sv�� index�� ����.
    } // end of while
  }

 

// ������ cycle�� �̷�� �Ǵ��� �˾ƺ���.
  static boolean isCycle(int[] sv, int val, int cnt) {
    for (int i =0; i<cnt; i++) {
      if (sv[i] == val) {
        return true;
      }
    }
    return false;
  }

 

}


