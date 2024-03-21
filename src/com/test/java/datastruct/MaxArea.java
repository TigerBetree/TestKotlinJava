package com.test.java.datastruct;

/**
 * 盛最多水的容器
 * <a href="https://github.com/hanggegreat/CS-Tree/blob/master/%E7%AE%97%E6%B3%95/leetcode-TOP100.md#11%E7%9B%9B%E6%9C%80%E5%A4%9A%E6%B0%B4%E7%9A%84%E5%AE%B9%E5%99%A8">...</a>
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("最大容器盛水量为1: " + maxArea1(heights));
        System.out.println("最大容器盛水量为2: " + maxArea2(heights));
    }

    // 盛最多水的容器
    public static int maxArea1(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int h = height[l] < height[r] ? height[l++] : height[r--];
            res = Math.max(res, h * (r - l + 1));
        }
        return res;
    }

    public static int maxArea2(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            maxArea = Math.max(maxArea, currentArea);
            // 移动较短的线段，因为容器盛水量由较短的线段决定
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
