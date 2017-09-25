package Algortihm2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1057 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String tmp[] = in.readLine().split(" ");

		int num = Integer.parseInt(tmp[0]);

		int kim = Integer.parseInt(tmp[1]);
		int lim = Integer.parseInt(tmp[2]);

		int round = 0;

		while (true) {
			if (kim % 2 == 0 && lim % 2 == 0)// ¦¦
			{
				kim/=2;
				lim/=2;
				round++;
			} else if (kim % 2 == 0 && lim % 2 != 0)// ¦Ȧ
			{
				if(kim-lim==1){
					round++;
					break;
				}
				else
				{
					kim/=2;
					lim=lim/2+1;
					round++;
				}
			} else if (kim % 2 != 0 && lim % 2 == 0)// Ȧ¦
			{
				if(lim-kim==1){
					round++;
					break;
				}
				else
				{
					lim/=2;
					kim=kim/2+1;
					round++;
				}
			} else if (kim % 2 != 0 && lim % 2 != 0)// ȦȦ
			{
				kim=kim/2+1;
				lim=lim/2+1;
				round++;
			}

		}
		System.out.println(round);
	}

}
