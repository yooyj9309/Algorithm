package com.company;

public class LeetCode_67 {
  public String addBinary(String a, String b) {
    int carry = 0;
    StringBuilder result = new StringBuilder();

    int i = a.length() - 1;
    int j = b.length() - 1;

    while (i >= 0 || j >= 0) {
      int a1 = i >= 0 ? a.charAt(i) - '0' : 0;
      int b1 = j >= 0 ? b.charAt(j) - '0' : 0;

      int sum = (a1 + b1 + carry) % 2;
      carry = (a1 + b1 + carry) / 2;

      result.append(sum);
      i--;
      j--;
    }

    if(carry > 0) {
      result.append(1);
    }

    return result.reverse().toString();
  }


  public static void main(String[] args) {
    LeetCode_67 d = new LeetCode_67();

    System.out.println(d.addBinary("1010", "1011"));
  }
}
