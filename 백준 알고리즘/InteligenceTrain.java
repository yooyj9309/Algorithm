package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * À§¿¡ ÆÐÅ°Áö¶«¿¡ Æ²·È´Ù....
 * */
public class InteligenceTrain {
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int max=0,total=0;
		for (int i = 0; i < 4; i++) {
			String[] tmp = in.readLine().split(" ");
			int m=Integer.parseInt(tmp[0]);
			int r=Integer.parseInt(tmp[1]);
			total=total-m+r;
			if(max<total)
				max=total;
		}
		System.out.println(max);
	}
}
