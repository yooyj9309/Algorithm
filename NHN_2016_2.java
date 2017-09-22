import java.util.Scanner;

public class NHN_2016_2 {
	public static String reverseString(String s) {
		return (new StringBuffer(s)).reverse().toString();
	}
	public static boolean isPal(int a)
	{
		boolean result=false;
		String tmp=""+a;
		if(tmp.equals(reverseString(tmp)))
			result=true;
		else
			result=false;
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		String s=""+n;
		String rs=reverseString(s);
		
		int rn=Integer.parseInt(rs);
		int answer=-1;
		int result = 0;
		
		for(int i=0;i<3;i++)
		{
			result=n+rn;
			if(isPal(result))
			{
				answer=result;
				break;
			}
			else
			{
				if(result>=10000)
				{
					answer=-1;
					break;
				}
				else
				{
					n=result;
					String t=reverseString(""+n);
					rn=Integer.parseInt(t);
				}
			}
		}
		System.out.println(answer);
	}

}
