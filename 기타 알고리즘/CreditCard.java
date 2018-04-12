import java.util.Scanner;

public class CreditCard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();
		scan.nextLine();
		for(int i=0;i<num;i++)
		{
			String str=scan.nextLine();
			int cardNum[]=new int[16];
			for(int j=str.length()-1;j>=0;j--)
			{
				String c=str.substring(j,j+1);
				int digit=Integer.parseInt(c);
				if(j%2==0)
				{
					int tmp=digit*2;
					if(tmp>=10)
					{
						cardNum[j]=tmp/10+tmp%10;
					}
					else
						cardNum[j]=tmp;
				}
				else
					cardNum[j]=Integer.parseInt(c);
			}
			
			int sum=0;
			for(int j=0;j<16;j++){
				sum+=cardNum[j];
				System.out.print(cardNum[j]);
			}
			if(sum%10==0)
				System.out.println("T");
			else
				System.out.println("F");
			
		}
	}

}
