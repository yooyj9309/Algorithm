package com.company;

public class LeetCode_704 {
  public int search(int[] nums, int target) {
    int right = nums.length - 1;
    int left = 0;

//    if(left == right && nums[right] == target) {
//      return right;
//    }

    while (left <= right) {
      int index = (left + right) / 2;

      if (nums[index] < target) {
        left = index + 1;
        continue;
      }
      if (nums[index] > target) {
        right = index - 1;
        continue;
      }
      if(nums[index] == target) {
        return index;
      }
    }
    return -1;
  }

  public static void main(String[] args) {

    LeetCode_704 d = new LeetCode_704();
    int[] nums = {5};
    System.out.println(d.search(nums, 5));
  }
}
