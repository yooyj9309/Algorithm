import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 생각해보니까 split('-') 한번해두고
 * 맨처음 스트링 어레이만 +연산 처리했으면 끝났다..
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
