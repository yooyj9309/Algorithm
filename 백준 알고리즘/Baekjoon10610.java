import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon10610 {

	public static String isThirty(char[] numList) {
		String result = "-1";
		int sum = 0;
		if (numList[0] - '0' == 0) {
			for (int i = 0; i < numList.length; i++) {
				sum += numList[i] - '0';
			}
			if (sum % 3 == 0) {
				result=reverse(numList);
			}
		}
		return result;
	}
	public static String reverse(char[] numList)
	{
		String result="";
		for(int i=numList.length-1;i>=0;i--)
		{
			result+=numList[i];
		}
		return result;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();
		char[] numList = input.toCharArray();
		Arrays.sort(numList);
		System.out.println(isThirty(numList));
	}

}
