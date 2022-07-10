package com.yxh.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yxh
 * @description
 * @time 2022/7/9 10:28
 */
public class CharacterUtil {
    public static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    public static boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public static boolean isChinese(char ch) {
        return String.valueOf(ch).matches("[\\u4e00-\\u9fa5]");
    }

    public static boolean isMark(char s) {
        return String.valueOf(s).matches("\\pP");
    }
}
