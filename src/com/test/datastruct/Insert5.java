package com.test.datastruct;

/**
 * 给定一个数字，在数字的任意位置插入一个5，使得插入后的这个数字最大。
 * <p>
 * 输入:  a = 234
 * 输出: 5234
 */
public class Insert5 {

    public static void main(String[] args) {
        System.out.println(insertFive(234));
        System.out.println(insertFive(-234));
        System.out.println(insertFive(0));
    }

    public static int insertFive(int num) {
        boolean isNegative = num < 0;
        // write your code here
        String numStr = String.valueOf(num);
        if (isNegative) {
            numStr = numStr.substring(1);
        }
        int maxNum = Integer.MIN_VALUE;
        // 在每个可能的位置插入 '5'
        for (int i = 0; i <= numStr.length(); i++) {
            // 创建一个新的字符串，将 '5' 插入到位置 i
            String newNumStr = numStr.substring(0, i) + "5" + numStr.substring(i);
            if (isNegative) {
                newNumStr = "-" + newNumStr;
            }
            // 将新的字符串转换回数字并更新最大值
            maxNum = Math.max(maxNum, Integer.parseInt(newNumStr));
        }
        return maxNum;
    }
}
