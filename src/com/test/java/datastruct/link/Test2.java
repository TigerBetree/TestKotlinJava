<<<<<<<< HEAD:src/com/test/java/datastruct/Test2.java
package com.test.datastruct.test;

import java.util.HashMap;
import java.util.Map;
========
package com.test.java.datastruct.link;
>>>>>>>> origin/main:src/com/test/java/datastruct/link/Test2.java

public class Test2 {

    public static void main(String[] args) {
//        String s = "This is a sample";
//        String[] sArray = s.split("\\ ");
//        for(int i = 0; i < sArray.length; i++){
//            System.out.println(sArray[i]);
//        }
//        int len = sArray.length;
//        StringBuffer sb = new StringBuffer();
//        for(int i = len - 1; i  >= 0; i--){
//            String temp = sArray[i];
//            sb.append(temp.toUpperCase());
//            if(i > 0){
//                sb.append(" ");
//            }
//        }
//        System.out.println(sb.toString());

        System.out.println(trans(" h i", 4));
    }

    public static String trans(String s, int n) {
        // write code here
        StringBuffer sb = new StringBuffer();
        if (s.endsWith(" ")) {
            sb.append(" ");
        }

        String origS = s;
        String[] sArray = s.trim().split("\\ ");
        int len = sArray.length;

        for (int i = len - 1; i  >= 0; i--) {
            String temp = sArray[i];
            sb.append(revers(temp));
            if (i > 0) {
                sb.append(" ");
            }
        }
        System.out.println("origS : " + origS);
        if (origS.startsWith(" ")) {
            return sb.toString() + " ";
        } else {
            return sb.toString();
        }
    }

    public static String revers(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                sb.append(Character.toUpperCase(c));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;//用于记录最大不重复子串的长度
        int left = 0;//滑动窗口左指针
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            //不管是否更新left，都要更新 s.charAt(i) 的位置！
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - left + 1);
        }

        return maxLen;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
