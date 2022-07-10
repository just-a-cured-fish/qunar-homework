package com.yxh.question3;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.io.LineProcessor;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author yxh
 * @description
 * @time 2022/7/2 15:42
 */
public class IndexOrderLineProcessor  implements LineProcessor<LinkedHashMap<String, String>> {
    private final Splitter SPLITTER = Splitter.onPattern("\\s+");
    private LinkedHashMap<String, String> indexOrderMap = new LinkedHashMap<>();

    @Override
    public boolean processLine(String s) throws IOException {
        String key = Iterables.get(SPLITTER.splitToList(s), 0);
        String value = Iterables.get(SPLITTER.split(s), 1);
        indexOrderMap.put(key, value);
        return true;
    }

    @Override
    public LinkedHashMap<String, String> getResult() {
        return indexOrderMap;
    }
}
