package com.yxh.question2.impl;

import com.yxh.core.entity.CountBean;
import com.yxh.question2.CodeCountService;

import java.util.List;

/**
 * @author yxh
 * @description 代码空行统计器
 * @time 2022/7/10 16:34
 */
public class SpaceCodeCountServiceImpl extends AbstracttCodeCountService {
    @Override
    public Integer count(List<String> lines, CountBean countBean) {
        if(lines.get(countBean.getIndex()).trim().isEmpty()){
            increaseIndex(countBean,ONE);
            return ONE;
        }
        return ZERO;
    }

    @Override
    public void printCount() {
        System.out.println("空行代码行数为:"+count);
    }

    @Override
    public Integer getCount(){
        return count;
    }
}
