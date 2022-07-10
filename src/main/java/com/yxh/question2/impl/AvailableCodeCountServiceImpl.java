package com.yxh.question2.impl;

import com.yxh.core.entity.CountBean;

import java.util.List;

/**
 * @author yxh
 * @description 有效代码必须要在list 中最后一个
 * @time 2022/7/10 17:08
 */
public class AvailableCodeCountServiceImpl extends AbstracttCodeCountService {
    @Override
    public Integer count(List<String> lines, CountBean countBean) {
        count++;
        countBean.setIndex(countBean.getIndex() + 1);
        return ZERO;
    }

    @Override
    public void printCount() {
        System.out.println("有效代码行数为:" + count);
    }

    @Override
    public Integer getCount() {
        return count;
    }
}
