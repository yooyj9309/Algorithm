package SamsungExpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SW_packet {

	static boolean is=false;
	public static Integer[] getIndex(int size, String input) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		char[] cmpList = input.toCharArray();
		for (int i = 0; i < size; i++) {
			if (cmpList[i] == cmpList[0])
				list.add(i);
		}
		if (cmpList[size - 1] != cmpList[0]){
			list.add(size - 1);
			is=true;
		}
		return list.toArray(new Integer[list.size()]);
	}

	public static int getMinNumber(int size, String input) {
		Integer[] idxArray = getIndex(size, input);
		String cmp = input.substring(idxArray[0], idxArray[1]);

		if (idxArray.length > 2) {
			for (int i = 2; i < idxArray.length; i++) {
				String tmp = input.substring(idxArray[i - 1], idxArray[i]);
				if (!cmp.equals(tmp)) {
					cmp = input.substring(idxArray[0], idxArray[i]);
				} else if (cmp.equals(tmp)) {
					break;
				}
			}
		}
		System.out.println(cmp);
		return cmp.length();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < 2; i++) {
			int size = Integer.parseInt(in.readLine());
			String input = in.readLine();
			System.out.println("#"+(i+1)+" "+getMinNumber(size, input));
		}
	}

}
