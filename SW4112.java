package SamsungExpert;

import java.util.Scanner;

public class SW4112 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int num = 1; num <= tc; num++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			int alevel=0;
			int blevel=0;
			int ans=0;
			for(int i=1;i<200;i++)
			{
				int lstart=(i*i-i+2)/2;
				int lend=(i*i+i)/2;
				
				if(lstart<=a&&a<=lend)
					alevel=i;
				if(lstart<=b&&b<=lend)
					blevel=i;
			}
			if(alevel==blevel)
				ans=Math.abs(a-b);
			else
			{
				int minlevel=Math.min(alevel, blevel);
				int maxlevel=Math.max(alevel, blevel);
				int dif=maxlevel-minlevel;
				
				int min=Math.min(a, b);//9
				int max=Math.max(a, b);//22
				
				int left=min;
				int right=min;
				
				for(int i=0;i<dif;i++)
				{
					left+=minlevel+i;
					right+=minlevel+i+1;
				}
				if(left<=max&&max<=right)
					ans=dif;
				else if(left>max)
					ans=dif+(left-max);
				else if(right<max)
					ans=dif+(max-right);
			}
			System.out.println("#"+num+" "+ans);
		}
	}

}
