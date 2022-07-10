package com.yxh.question4;

import java.io.IOException;

/**
 * @author yxh
 * @description
 * @time 2022/7/6 12:44
 */
public class ShellMain {
    public static void main(String[] args) {
        String shell="cat D:\\qunar\\qunar-homework\\target\\classes\\doc\\attachments\\Question3\\sdxl.txt &&" +
                "cat D:\\qunar\\qunar-homework\\target\\classes\\doc\\attachments\\Question3\\sdxl.txt | grep 水 &&" +
                "wc -l D:\\qunar\\qunar-homework\\target\\classes\\doc\\attachments\\Question3\\sdxl.txt &&" +
                "cat D:\\qunar\\qunar-homework\\target\\classes\\doc\\attachments\\Question3\\sdxl.txt | grep 水 | wc -l";
        try {
            new ShellParse().run(shell);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
