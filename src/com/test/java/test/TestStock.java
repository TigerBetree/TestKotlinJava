package com.test.java.test;

public class TestStock {

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxPrice(prices));
        int[] prices2 = {7, 6, 4, 3, 2, 1};
        System.out.println(maxPrice(prices2));
    }

    /**
     * 只交易一次股票，赚的钱最多是多少
     */
    private static int maxPrice(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        }
        return max;
    }
}
