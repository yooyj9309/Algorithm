import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class midas2 {

	public static String reverseString(String s) {
		return (new StringBuffer(s)).reverse().toString();
	}

	public static boolean isPal(String tmp) {
		boolean result = false;
		if (tmp.equals(reverseString(tmp)))
			result = true;
		else
			result = false;

		return result;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		int cnt = 0;

		for (int i = 0; i < num; i++) {
			String str = in.readLine();
			if (isPal(str))
				cnt=0;
			else {
				for (int j = 0; j < str.length() / 2; j++) {
					String s = str.substring(j, j + 1);
					String f = str.substring(str.length() - 1 - j, str.length() - j);
					if (s.charAt(0) < f.charAt(0)) {
						int tmp = f.charAt(0);

						while (true) {
							if (s.charAt(0) == tmp) {
								break;
							} else {
								tmp--;
								cnt++;
							}
						}

					} else if (s.charAt(0) > f.charAt(0)) {
						int tmp = s.charAt(0);

						while (true) {
							if (f.charAt(0) == tmp) {
								break;
							} else {
								tmp--;
								cnt++;
							}
						}
					} 
				}
			}
			System.out.println(cnt);
			cnt = 0;

		}

	}

}
