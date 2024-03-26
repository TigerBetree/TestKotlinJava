package com.test.java.datastruct;

public class Test {

    public static void main(String[] args) {
        testGenKuoHao("", 0, 0, 3);
    }

    /**
     * 括号生成（全排列）
     *
     * @param s
     * @param left
     * @param right
     * @param n
     */
    private static void testGenKuoHao(String s, int left, int right, int n) {
        if (left == n && right == n) {
            System.out.println(s);
            return;
        }

        if (left < n) {
            testGenKuoHao(s + "(", left + 1, right, n);
        }

        if (right < left) {
            testGenKuoHao(s + ")", left, right + 1, n);
        }
    }
}
