import java.util.Arrays;
import java.util.Scanner;

public class NHN_2016_1 {

	//int�� double���� ���� ������ 10�ڸ��� �Ѵ� �ڿ����� �Էµ�
	// �׷��Ƿ� long Ÿ���� ��������ν� �޾��ְ� �ذ�����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		long[] arr=new long[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=scan.nextLong();
		}
		Arrays.sort(arr);
		
		long min=Long.MAX_VALUE;
		long k = 0,l = 0;
		
		for(int i=1;i<n;i++)
		{
			if(arr[i]-arr[i-1]<min)
			{
				min=arr[i]-arr[i-1];
				k=arr[i-1];
				l=arr[i];
			}
		}
		System.out.println(k+" "+l);
	}

}
