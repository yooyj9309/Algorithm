import java.util.Scanner;

public class Sangsu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String tmp1[]=new String[2];
		
	for(int firstLoop=0;firstLoop<2;firstLoop++){
		int num1=scan.nextInt();
		tmp1[firstLoop]="";
		while(num1>0)
		{
			tmp1[firstLoop]+=num1%10;
			num1=num1/10;
		}
	}
	if(Integer.parseInt(tmp1[0])>Integer.parseInt(tmp1[1]))
		System.out.println(tmp1[0]);
	else
		System.out.println(tmp1[1]);
	}

}
