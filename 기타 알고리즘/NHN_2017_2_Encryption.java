import java.util.Scanner;

public class NHN_2017_2_Encryption {
	public static String rotate(String s) {
		String tmp = "";
		for (int i = 1; i < s.length(); i++) {
			tmp += s.charAt(i);
		}
		tmp = tmp + s.charAt(0);
		return tmp;
	}

	public static String rotate1(String s) {
		String tmp = "";
		tmp = tmp + s.charAt(s.length() - 1);
		for (int i = 0; i < s.length() - 1; i++) {
			tmp += s.charAt(i);
		}
		return tmp;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String inputLine = scan.nextLine();
		String input[] = inputLine.split(" ");
		String type = input[0];

		if (type.equals("encrypt")) {
			String str1 = input[1];
			str1 = str1.toLowerCase();

			int num = Integer.parseInt(input[2]);

			String str2 = input[3];
			str2 = str2.toLowerCase();

			String addString = "";

			for (int i = 0; i < str1.length(); i++) {
				String s = str2.substring(i, i + 1);
				String s1 = str1.substring(i, i + 1);
				char tmp;
				if ((s.charAt(0) - 97 + s1.charAt(0) - 97) > 25) {
					tmp = (char) (s.charAt(0) - 97 + s1.charAt(0) - 26);
				} else
					tmp = (char) (s.charAt(0) + s1.charAt(0) - 97);
				addString += tmp;
			}
			String decryption = addString;
			if (num >= 0) {
				for (int i = 0; i < num; i++) {
					decryption = rotate(decryption);
				}
			} else {
				num = num * -1;
				for (int i = 0; i < num; i++) {
					decryption = rotate1(decryption);
				}
			}
			System.out.println(decryption);
		} else if (type.equals("decrypt")) {
			String str1 = input[1];
			str1 = str1.toLowerCase();

			int num = Integer.parseInt(input[2]);

			String str2 = input[3];
			str2 = str2.toLowerCase();

			String backToString = "";
			String tmp = str2;
			if (num >= 0) {
				for (int i = 0; i < num; i++) {
					tmp = rotate1(tmp);
				}
				backToString = tmp;
			} else {
				num = num * -1;
				for (int i = 0; i < num; i++) {
					tmp = rotate(tmp);
				}
				backToString = tmp;
			}

			String answer = "";

			for (int i = 0; i < str1.length(); i++) {
				String s = backToString.substring(i, i + 1);
				String s1 = str1.substring(i, i + 1);

				char tmp1;

				if ((s.charAt(0) - s1.charAt(0)) < 0) {
					tmp1 = (char) (s.charAt(0) - s1.charAt(0) + 26 + 97);
				} else
					tmp1 = (char) (s.charAt(0) - s1.charAt(0) + 97);
				answer += tmp1;
			}
			System.out.println(answer);
		}
	}
}
