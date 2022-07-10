package com.yxh.question2.impl;

import com.yxh.core.entity.CountBean;

import java.util.List;

/**
 * @author yxh
 * @description 单行注释代码统计
 * @time 2022/7/10 16:44
 */
public class SingleLineCountServiceImpl extends AbstracttCodeCountService {
    private final static String pre = "//";

    @Override
    public Integer count(List<String> lines, CountBean countBean) {
        if (lines.get(countBean.getIndex()).trim().startsWith(pre)) {
            increaseIndex(countBean, ONE);
            return ONE;
        }
        return ZERO;
    }

    @Override
    public void printCount() {
        System.out.println("单行注释代码行数为:"+count);
    }

    @Override
    public Integer getCount(){
        return count;
    }
}
