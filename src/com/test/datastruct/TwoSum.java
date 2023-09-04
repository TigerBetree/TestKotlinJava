package com.test.datastruct;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
//        int[] nums = new int[]{2, 7, 11, 15};
//        int[] nums = new int[]{3, 2, 4};
        int[] nums = new int[]{0, 4, 3, 0};
        System.out.println(Arrays.toString(twoSum(nums, 0)));
    }

    /**
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
//        int first = 0, second = 0;
//        for (int i = 0; i < nums.length; i++) {
//            first = i;
//            second = i + 1;
//            while (second < nums.length) {
//                if (nums[first] + nums[second] == target) {
//                    return new int[]{first, second};
//                } else {
//                    second++;
//                }
//            }
//        }
//
//        return null;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
