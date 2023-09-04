package com.test.java.sogou;

import java.util.regex.Pattern;

public class CheckUrl {

    public static void main(String[] args) {
        Pattern webUrlPattern = PatternsSDK28.AUTOLINK_WEB_URL;

        String url = "www.sogou.vip";
        boolean result = webUrlPattern.matcher(url).matches();
        System.out.println(result);

        String tempStr = url.substring(0, url.length() - 4) + ".com";
        System.out.println(webUrlPattern.matcher(tempStr).matches());


        String s = "39.992483304166704";
        System.out.println(Double.parseDouble(s));
    }
}
