import java.util.Scanner;

public class NHN_2016_3 {

	public static boolean condition1(String s)
	{
		boolean result=false;
		int cnt=0;
		for(int i=0;i<s.length();i++)
		{
			String tmp=s.substring(i,i+1);
			if(tmp.equalsIgnoreCase("a")||tmp.equalsIgnoreCase("o")||
					tmp.equalsIgnoreCase("e")||tmp.equalsIgnoreCase("u")||
					tmp.equalsIgnoreCase("i"))
			{
				cnt++;
			}
			else
			{
				cnt=0;
			}
		if(cnt==2){
			result=true;
			break;
		}
		else
			result=false;
		}
		return result;
	}
	public static boolean condition2(String s)
	{
		boolean result=false;
		int cnt1=0;
		for(int i=0;i<s.length();i++)
		{
			String tmp=s.substring(i,i+1);
			if(tmp.equalsIgnoreCase("a")||tmp.equalsIgnoreCase("o")||
					tmp.equalsIgnoreCase("e")||tmp.equalsIgnoreCase("u")||
					tmp.equalsIgnoreCase("i"))
			{
				cnt1=0;
			}
			else
			{
				cnt1++;
			}
		if(cnt1==3){
			result=true;
			break;
		}
		else
			result=false;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str=scan.nextLine();
		String[] words=str.split(" ");
		int cnt1=0,cnt2=0;
		
		for(int i=0;i<words.length;i++)
		{
			
			if(condition1(words[i]))
			{
				System.out.println("1"+words[i]);
				cnt1++;
			}
			if(condition2(words[i]))
			{
				System.out.println("2"+words[i]);
				cnt2++;
			}
		}
		System.out.println(cnt1);
		System.out.println(cnt2);
		
	}

}
