package com.test.java.datastruct;

/**
 * 盛最多水的容器
 * https://github.com/hanggegreat/CS-Tree/blob/master/%E7%AE%97%E6%B3%95/leetcode-TOP100.md#11%E7%9B%9B%E6%9C%80%E5%A4%9A%E6%B0%B4%E7%9A%84%E5%AE%B9%E5%99%A8
 */
public class MaxArea {

    public static int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int h = height[l] < height[r] ? height[l++] : height[r--];
            res = Math.max(res, h * (r - l + 1));
        }
        return res;
    }
}
