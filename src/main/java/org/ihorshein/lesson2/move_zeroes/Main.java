package org.ihorshein.lesson2.move_zeroes;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/move-zeroes/description/">
 *   Lesson 2 HW; Move Zeroes
 * </a>
 */
@SuppressWarnings("checkstyle:MagicNumber")
public final class Main {
  public static void main(String[] args) {
    example1();
    example2();
  }

  private void moveZeroes(int[] nums) {
    int numberPosition = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        if (numberPosition != i) {
          nums[numberPosition] = nums[i];
        }

        numberPosition++;
      }
    }

    for (int i = numberPosition; i < nums.length; i++) {
      nums[i] = 0;
    }
  }

  public static void example1() {
    Main solution = new Main();

    int[] nums = {0, 1, 0, 3, 12};
    solution.moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }

  public static void example2() {
    Main solution = new Main();

    int[] nums = {0};
    solution.moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }
}
