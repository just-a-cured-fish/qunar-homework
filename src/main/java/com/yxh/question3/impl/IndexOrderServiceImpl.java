package com.yxh.question3.impl;

import com.yxh.question3.DecodeMain;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author yxh
 * @description
 * @time 2022/7/2 16:27
 */
public class IndexOrderServiceImpl extends AbstractOrderService {
    LinkedHashMap<String, String> map;

    public IndexOrderServiceImpl(List<String> lines, LinkedHashMap<String, String> map) {
        super(lines);
        this.map = map;
    }

    @Override
    public String order(String s) {
        s = s.substring(s.indexOf(DecodeMain.TEMPLATE_PRE_MARKER) + 1, s.indexOf(DecodeMain.TEMPLATE_SUFFIX_MARKER));
        return map.get(s);
    }
}
