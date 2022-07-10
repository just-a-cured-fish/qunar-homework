package com.yxh.question2.impl;

import com.yxh.core.entity.CountBean;
import com.yxh.question2.CodeCountService;

/**
 * @author yxh
 * @description
 * @time 2022/7/10 16:37
 */
public abstract class AbstracttCodeCountService implements CodeCountService {
    protected final static Integer ZERO = 0;

    protected final static Integer ONE = 1;

    protected Integer count = 0;

    protected void increaseIndex(CountBean countBean, Integer index) {
        countBean.setCount(countBean.getCount() + index);
        count += index;
        countBean.setIndex(countBean.getIndex() + index);
    }



}
