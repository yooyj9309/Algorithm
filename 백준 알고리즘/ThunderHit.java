import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * DP����, ���� �ð� ������ ������ �ִ븦 �����ϴ� ����
 * t���� k �ð����� ���鼭 ������ �Է� (ex 310~50)
 * �ι�° �Է�, t�� �ѱ��� �ʴ� �������� �ִ�ð��� ã��(ex 310~150���� �� ������ �Է��� ���� �� ����)
 * ����° �Է�, 310�ð�¥���� 110�ð� + ����° �Է¿��� ���� ���� �� 
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
