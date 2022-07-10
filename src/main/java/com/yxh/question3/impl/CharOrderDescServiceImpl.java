package com.yxh.question3.impl;

import com.google.common.collect.Ordering;

import java.util.Collections;
import java.util.List;

/**
 * @author yxh
 * @description
 * @time 2022/7/2 17:12
 */
public class CharOrderDescServiceImpl extends AbstractOrderService{
    public CharOrderDescServiceImpl(List<String> lines) {
        super(lines);
        Collections.sort(lines,Ordering.natural().reverse());
    }
}
