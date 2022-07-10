package com.yxh.question2.impl;

import com.yxh.core.entity.CountBean;

import java.util.List;

/**
 * @author yxh
 * @description 多行注释代码统计器
 * @time 2022/7/10 16:48
 */
public class MutiiLineCountServiceImpl extends AbstracttCodeCountService {
    public static final String PRE = "/*";

    public static final String SUFFIX = "*/";

    @Override
    public Integer count(List<String> lines, CountBean countBean) {
        //1.找多行代码注释前缀
        if (lines.get(countBean.getIndex()).trim().startsWith(PRE)) {
            int index = countBean.getIndex() + 1;
            while (index < lines.size() - 1) {
                if (lines.get(index).trim().endsWith(SUFFIX)) {
                    index++;
                    break;
                }
                index++;
            }
            index = index - countBean.getIndex();
            increaseIndex(countBean, index);
            return index;
        }
        return ZERO;
    }

    @Override
    public void printCount() {
        System.out.println("多行注释代码行数为:" + count);
    }

    @Override
    public Integer getCount(){
        return count;
    }
}
