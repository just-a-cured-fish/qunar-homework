package com.yxh.question2;

import com.yxh.core.entity.CountBean;

import java.util.List;

/**
 * @author yxh
 * @description
 * @time 2022/7/10 16:27
 */
public interface CodeCountService {
    /**
     * 根据文本 和行数 统计此类别代码的行数
     * @param countBean
     * @param lines 代码文本
     * @return
     */
    Integer count(List<String> lines, CountBean countBean);

    /**
     * 打印出此统计类统计出的代码行数
     */
    void printCount();

    /**
     * 获取代码行数
     * @return
     */
    public Integer getCount();
}
