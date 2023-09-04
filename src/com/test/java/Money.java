package com.test.java;

public class Money {

    public static void main(String[] args) {
        float zhangle = 179497.12f; // 涨乐财富宝
        float qieman = 158992.86f; // 且慢
        float guangfa = 145810.82f; // 广发基金

        float fgzzhli = 154745.3f; // 富国中证红利
        float fghs300 = 29017.47f; // 富国沪深300
        float fgzz500 = 25523.62f; // 富国中证500

        float fuguo = fgzzhli + fghs300 + fgzz500;
        System.out.println("富国总计 : " + fuguo);

        float qita = zhangle + qieman + guangfa;
        System.out.println("不含富国总计 : " + qita);

        float sum = qita + fuguo;
        System.out.println("总计 : " + sum);

    }
}
