package com.test.java.datastruct;

public class MoveZeroes {

    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }

        while (j < nums.length) {
            nums[j] = 0;
        }
    }
}
