package com.myspring.config;

public class URLUtils {
    public static String reURL(String url) {
        char[] chars = url.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='.'){
                chars[i]='/';
            }
        }

//        for (byte aByte : bytes) {
//            System.out.println(aByte);
//        }
        System.out.println(new String(chars));
        return new String(chars);
    }
}
