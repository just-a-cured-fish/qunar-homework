package com.yxh.question3.impl;

import com.yxh.question3.DecodeMain;
import com.yxh.question3.OrderService;

import java.util.List;

/**
 * @author yxh
 * @description
 * @time 2022/7/2 16:13
 */
public class AbstractOrderService implements OrderService {
    private List<String> lines;

    AbstractOrderService(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public String order(String s) {
        s = s.substring(s.indexOf(DecodeMain.TEMPLATE_PRE_MARKER) + 1, s.indexOf(DecodeMain.TEMPLATE_SUFFIX_MARKER));
        return lines.get(Integer.parseInt(s));
    }
}
