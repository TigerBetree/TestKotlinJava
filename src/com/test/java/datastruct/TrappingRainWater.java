package com.test.java.datastruct;

import java.util.Stack;

/**
 * 接雨水问题
 */
public class TrappingRainWater {
    // 方法1：动态规划
    // 方法2：双指针
    // 方法3：栈

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("可以接的雨水量为：" + trap(height));
        System.out.println("可以接的雨水量为：" + trap2(height));
        System.out.println("可以接的雨水量为：" + trapDynamic(height));
        System.out.println("可以接的雨水量为：" + trapStack(height));
    }

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, result = 0;
        while (left < right) {
            // 左边的高度小于右边，则处理左边
            if (height[left] < height[right]) {
                // 更新左边最大高度
                leftMax = Math.max(leftMax, height[left]);
                // 计算当前柱子可以接的雨水量
                result += leftMax - height[left];
                left++; // 移动左指针
            } else { // 右边的高度小于等于左边，则处理右边
                // 更新右边最大高度
                rightMax = Math.max(rightMax, height[right]);
                // 计算当前柱子可以接的雨水量
                result += rightMax - height[right];
                right--; // 移动右指针
            }
        }
        return result;
    }
    public static int trap2(int[] height) {
        int res = 0;
        int lMax = 0, rMax = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            lMax = Math.max(lMax, height[l]);
            rMax = Math.max(rMax, height[r]);
            if (lMax < rMax) {
                res += lMax - height[l++];
            } else {
                res += rMax - height[r--];
            }
        }
        return res;
    }

    public static int trapStack(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int water = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                water += distance * boundedHeight;
            }
            stack.push(i);
        }
        return water;
    }

    public static int trapDynamic(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        // 初始化左边最高墙
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // 初始化右边最高墙
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        // 计算每个位置可以接的雨水量
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
}
