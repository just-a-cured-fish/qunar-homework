package com.yxh.question3;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.io.LineProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yxh
 * @description
 * @time 2022/7/2 20:20
 */
public class LineParseProcessor implements LineProcessor<List<String>> {
    private final Splitter SPLITTER = Splitter.onPattern("\\s+");
    private List<String> list = new ArrayList<>();

    @Override
    public boolean processLine(String s) throws IOException {
        String value = Iterables.get(SPLITTER.split(s), 1);
        list.add(value);
        return true;
    }

    @Override
    public List<String> getResult() {
        return list;
    }
}
