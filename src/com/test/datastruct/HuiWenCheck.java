package com.test.datastruct;

/**
 * 验证回文
 *
 * https://leetcode-cn.com/problems/valid-palindrome/submissions/
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
}
