package com.test.datastruct;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号
 */
public class GenKuoHao {
    private List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        GenKuoHao genKuoHao = new GenKuoHao();
        List<String> list = genKuoHao.generateParenthesis(3);
        System.out.println(list);
    }

    public List<String> generateParenthesis(int n) {
        helper("", 0, 0, n);
        return results;
    }

    /**
     * 1. 左括号随时可以添加，只要别超标
     * 2. 右括号：必须之前有左括号，且个数小于左括号个数
     * @param s     生成的中间结果
     * @param left  左括号个数
     * @param right 右括号个数
     * @param n     左右括号分别总个数，两个括号是成对出现，所以个数一致
     */
    private void helper(String s, int left, int right, int n) {
        // 左右括号都放满了
        if (left == n && right == n) {
            results.add(s);
            return;
        }

        // 如果可以放置左括号，那就放一个左括号
        if (left < n) {
            helper(s + "(", left + 1, right, n);
        }
        // 右括号个数小于左括号个数，则挨着左括号放一个右括号
        if (right < left) {
            helper(s + ")", left, right + 1, n);
        }
    }
}
