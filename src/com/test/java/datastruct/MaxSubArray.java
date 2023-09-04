package com.test.java.datastruct;

/**
 * 最大子数组和
 * https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
 */
public class MaxSubArray {

    public int maxSubArray1(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        //定义dp数组，dp数组中的每个值dp[i]代表着以nums[i]为结尾的最大子序和
        int[] dp = new int[n];

        //以nums[0]结尾的最大子序和就是nums[0]
        dp[0] = nums[0];

        //遍历，通过状态转移方程求得dp[i]的最大子序和
        for (int i = 1; i < n; ++i) {
            //dp[i]的最大子序和要么是自成一派最大，要么就是当前值加上前面i - 1个数的最大子序和
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        //遍历dp数组，求得dp数组中的最大值，就是该题的答案
        int res = Integer.MIN_VALUE;
        for (int j = 0; j < dp.length; ++j) {
            res = Math.max(res, dp[j]);
        }
        return res;
    }
}
