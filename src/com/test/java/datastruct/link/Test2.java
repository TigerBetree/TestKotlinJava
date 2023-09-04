package com.test.java.datastruct.link;

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
}
