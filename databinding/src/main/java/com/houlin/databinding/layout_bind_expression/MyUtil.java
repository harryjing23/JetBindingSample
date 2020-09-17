package com.houlin.databinding.layout_bind_expression;

/**
 * @author Harry Jing
 * @date 2020/9/16
 */
public class MyUtil {

    /**
     * 将所有字符+1
     */
    public static String plusOne(String str) {
        StringBuilder result = new StringBuilder();
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                c++;
                result.append(c);
            }
        }
        return result.toString();
    }
}
