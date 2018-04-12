import java.util.Arrays;
import java.util.Scanner;

public class NHN_2016_1 {

	//int랑 double에서 받을 수없는 10자리가 넘는 자연수가 입력됨
	// 그러므로 long 타입을 사용함으로써 받아주고 해결하자
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
