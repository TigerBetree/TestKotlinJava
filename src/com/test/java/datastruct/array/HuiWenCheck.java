package com.test.java.datastruct.array;

/**
 * 验证回文
 * <a href="https://leetcode-cn.com/problems/valid-palindrome/submissions/">...</a>
 */
public class HuiWenCheck {
    public static void main(String[] s) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(checkHuiWen(str));
    }

    // 验证回文："A man, a plan, a canal: Panama"
    public static boolean checkHuiWen(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        String str = s.replaceAll("[^0-9a-zA-Z]", "");
        str = str.toLowerCase();
        boolean result = true;
        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                result = false;
                break;
            }
        }
        return result;
    }

    boolean isPalindrome(String s) {
        // 一左一右两个指针相向而行
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
