import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class midas4 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(in.readLine());
		
		int [] ar=new int[num];
		ArrayList<Integer> a=new ArrayList<Integer>();
		
		for(int i=0;i<num;i++)
		{
			ar[i]=Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(ar);
		
		for(int i=0;i<num-1;i++){
			if(!a.contains(ar[i+1]-ar[i]))
			a.add(ar[i+1]-ar[i]);
		}
		
		int min=Integer.MAX_VALUE;
		for(int i=1;i<a.size();i++)
		{
			BigInteger b1=BigInteger.valueOf(a.get(i-1));
			BigInteger b2=BigInteger.valueOf(a.get(i));
			BigInteger gcd=b1.gcd(b2);
			
			if(gcd.intValue()<min)
			{
				min=gcd.intValue();
			}
		}

		int cmp=0;
		for(int i=ar[0];i<=ar[ar.length-1];i=i+min)
		{
			cmp++;
		}
		System.out.println(cmp-ar.length);
	}

}
