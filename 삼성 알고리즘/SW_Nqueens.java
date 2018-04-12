package SamsungExpert;

import java.util.Scanner;

public class SW_Nqueens {
    static int count = 0;
    public static boolean isPromising(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n]) 
            	return false;   // 같은 열인지
            if ((q[i] - q[n]) == (n - i)) 
            	return false;   // '\' 방향
            if ((q[n] - q[i]) == (n - i)) 
            	return false;   // '/' 방향
        }
        return true;
    }

    public static void enumerate(int N) {
        int[] a = new int[N];
        enumerate(a, 0);
    }

    public static void enumerate(int[] q, int n) {
        int N = q.length;
        // n이 끝까지 돌았다면 카운트를 증가한다.
        if (n == N) {
            count++;
        } else {
            for (int i = 0; i < N; i++) {
                q[n] = i;
                if (isPromising(q, n)) 
                	enumerate(q, n + 1);   // 유망하다면 계속 탐색(재귀호출)
            }
        }
    }

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	int tc=sc.nextInt();
        for (short n = 1; n <= tc; n++) {
        	int tmp=sc.nextInt();
            enumerate(tmp);
            System.out.println("#"+" "+count);
            count = 0;
        }
    }
}
