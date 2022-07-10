package com.yxh.core.entity;

/**
 * @author yxh
 * @description
 * @time 2022/7/9 11:12
 */
public class Result {
    private final int charCount;
    private final int chineseCount;
    private final int letterCount;
    private final int MarkCount;

    public Result(int charCount, int letterCount, int chineseCount, int MarkCount) {
        this.charCount = charCount;
        this.chineseCount = chineseCount;
        this.letterCount = letterCount;
        this.MarkCount = charCount;
    }

    @Override
    public String toString() {
        return "字符总数量为[" + charCount + "], 中文总数量为[" + chineseCount + "], 英文字符数量为[" + letterCount
                + "], 标点符号数量为[" + MarkCount + "]";
    }
}
