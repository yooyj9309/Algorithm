package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_717 {
  public boolean isOneBitCharacter(int[] bits) {
    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i < bits.length - 1; i++) {
      q.add(bits[i]);
    }

    while (true) {
      if(q.size() == 1 && q.peek()==1) {
        return false;
      }
      if (q.isEmpty()) {
        return true;
      }
      int t = q.peek();
      if (t == 1) {
        q.poll();
        q.poll();
      } else {
        q.poll();
      }
    }
  }

  public static void main(String[] args) {

    LeetCode_717 d =new LeetCode_717();
    int[] bits = {1,1,1,0};
    System.out.println(d.isOneBitCharacter(bits));
  }
}
