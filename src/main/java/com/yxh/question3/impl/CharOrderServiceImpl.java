package com.yxh.question3.impl;

import com.google.common.collect.Ordering;

import java.util.Collections;
import java.util.List;

/**
 * @author yxh
 * @description
 * @time 2022/7/2 17:10
 */
public class CharOrderServiceImpl extends AbstractOrderService{
    public CharOrderServiceImpl(List<String> lines) {
        super(lines);
        Collections.sort(lines,Ordering.natural());
    }

    @Override
    public String order(String s) {
        return super.order(s);
    }
}
