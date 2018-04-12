package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1987 {
   static char map[][] = null;
   static int max = 0;
   static int n = 0, m = 0;
   static boolean[] visit = new boolean[26];
   static boolean[][] visited=null;
   public static void dfs(char a, int x, int y, int len) {
      if (visit[a - 'A']) {
    	  System.out.println(a + " ");
         System.out.print("±Ê¿Ã " + len);
         System.out.println();
         if (max < len)
            max = len;
         return;
      } else {
         if (x + 1 < m&&!visited[y][x+1]) {
            System.out.print(a + " ");
            System.out.print("->"+" ");
            visit[a - 'A'] = true;
            dfs(map[y][x + 1], x + 1, y, len + 1);
         }
         if (x - 1 >= 0&&!visited[y][x-1]) {
            System.out.print(a + " ");
            System.out.print("<-"+" ");
            visit[a - 'A'] = true;
            dfs(map[y][x - 1], x - 1, y, len + 1);
         }
         if (y + 1 < n&&!visited[y+1][x]) {
            System.out.print(a + " ");
            System.out.print("v"+" ");
            visit[a - 'A'] = true;
            dfs(map[y + 1][x], x, y + 1, len + 1);
         }
         if (y - 1 >= 0&&!visited[y-1][x]) {
            System.out.print(a + " ");
            System.out.print("^"+" ");
            visit[a - 'A'] = true;
            dfs(map[y - 1][x], x, y - 1, len + 1);
         }
      }
      visit[a-'A']=false;

   }

   public static void main(String[] args) throws NumberFormatException, IOException {
      // TODO Auto-generated method stub
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String input[] = in.readLine().split(" ");
      n = Integer.parseInt(input[0]);
      m = Integer.parseInt(input[1]);
      map = new char[n+1][m+1];
      visited=new boolean[n+1][m+1];
      String a[] = new String[n];
      for(int i=0;i<n;i++)
    	  a[i] = in.readLine();

      for (int i = 0; i < n; i++)
         for (int j = 0; j < m; j++) {
            map[i][j] = a[i].toCharArray()[j];
         }
      dfs(map[0][0], 0, 0, 0);
      System.out.println(max);
   }

}