package com.test.java.test;

public class TestSubSequence {

    public static void main(String[] args) {
        String s1 = "HelloAndroid";
        String s2 = "Android";
        System.out.println(isSubSequence(s1, s2));
    }


    /**
     * 判断s2是否是s1的子数组
     */
    private static boolean isSubSequence(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == len2;
    }

    /**
     * 判断一个字符串s是否是另一个字符串t的子串
     */
    public static boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }
}
