package com.test.datastruct;

/**
 * 爬楼梯
 */
public class PaLouTi {

    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
//        return helper(n);
        if (n <= 2) {
            return n;
        }

        int step1 = 1;
        int step2 = 2;
        int step = 0;
        for (int i = 3; i < n; i++) {
            step = step1 + step2;
            step1 = step2;
            step2 = step;
        }
        return step;
    }

    private int helper(int n) {
        if (n <= 2) {
            return 2;
        }

        return helper(n - 1) + helper(n - 2);
    }


    public int climbStairs2(int n) {
        int[] mems = new int[n + 1];
        return helper2(mems, n);
    }

    private int helper2(int[] mem, int n) {
        if (mem[n] > 0) {
            return mem[n];
        }

        if (n == 1) {
            mem[n] = 1;
        } else if (n == 2) {
            mem[n] = 2;
        } else {
            mem[n] = helper2(mem, n - 1) + helper2(mem, n - 2);
        }
        return mem[n];
    }

}
