package com.test.java.datastruct;

import java.util.*;

public class MinNumTest {

    public static void main(String[] args) {
        System.out.println(hammingWeight(5));
        System.out.println(hammingWeight(6));

        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(exchange(nums)));
    }

    public static int[] exchange(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] % 2 == 0 && nums[r] % 2 == 1) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            } else {
                while (l < r && nums[l] % 2 == 1) {
                    l++;
                }
                while (l < r && nums[r] % 2 == 0) {
                    r--;
                }
            }
        }
        return nums;
    }

    public static int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int c = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                c++;
            }
            n = n / 2;
        }
        return c;
    }

    public static String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        return String.join("", list);
    }
}
