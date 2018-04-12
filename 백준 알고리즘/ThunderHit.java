import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * DP문제, 제한 시간 내에서 점수의 최대를 내야하는 문제
 * t부터 k 시간까지 돌면서 점수를 입력 (ex 310~50)
 * 두번째 입력, t를 넘기지 않는 범위에서 최대시간을 찾자(ex 310~150까지 두 라인의 입력을 더할 수 있음)
 * 세번째 입력, 310시간짜리랑 110시간 + 세번째 입력에서 받은 점수 비교 
 *  
 * */
public class ThunderHit {

	static int d[]=new int[10001];
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp=in.readLine().split(" ");
        
        int n=Integer.parseInt(tmp[0]);
        int t=Integer.parseInt(tmp[1]);
        int k,s;
       for(int i=n;i>0;i--)
       {
    	   String[] tmp1=in.readLine().split(" ");
           k=Integer.parseInt(tmp1[0]);
           s=Integer.parseInt(tmp1[1]);
           
           for(int j=t;j>=k;j--){
        	   d[j]=max(d[j],d[j-k]+s);
           }
       }
       System.out.println("answer"+d[t]);
	}
	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		if(i>=j)
			return i;
		else
			return j;
	}

}
