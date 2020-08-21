package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_107 {
  private static List<List<Integer>> a = new ArrayList<>();


  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  private void search(int depth, TreeNode node) {
    if (node == null) {
      return;
    } else {
      if (a.size() >= depth + 1) {
        a.get(depth).add(node.val);
      } else {
        a.add(new ArrayList<>());
        a.get(depth).add(node.val);
      }
      search(depth + 1, node.left);
      search(depth + 1, node.right);
    }
  }

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    search(0, root);
    Collections.reverse(a);
    return a;
  }

  public static void main(String[] args) {

  }
}
