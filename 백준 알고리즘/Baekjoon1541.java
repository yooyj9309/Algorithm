import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * �����غ��ϱ� split('-') �ѹ��صΰ�
 * ��ó�� ��Ʈ�� ��̸� +���� ó�������� ������..
 * */
public class Baekjoon1541 {

	public static int operator(String input) {
		int sum = 0;
		String num = input.replace("+", " ");
		num = num.replace("-", " ");
		String[] numArr = num.split(" ");

		for (int j = 0; j < numArr.length; j++) {
			if (!numArr[j].equals(""))
				sum += Integer.parseInt(numArr[j]);
		}
		return sum;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input = in.readLine();

		int minusIndex = input.indexOf("-");
		int sum = 0;
	
		if (minusIndex != -1) {
			sum += operator(input.substring(0, minusIndex));
			sum -= operator(input.substring(minusIndex, input.length()));
		} else
			sum += operator(input.substring(0, input.length()));
		
		System.out.println(sum);
	}

}
