package com.yxh.question4.impl;

import com.google.common.collect.Lists;
import com.yxh.core.util.FileUtil;
import com.yxh.question4.ShellService;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author yxh
 * @description
 * @time 2022/7/6 20:07
 */
public class GrepShellServiceImpl implements ShellService {
    @Override
    public List<String> run(List<String> parms, File file) throws IOException {
        return null;
    }

    @Override
    public List<String> runWithPipe(List<String> parms, List<String> lines) {
        List<String> result=Lists.newArrayList();
        String grepWord=parms.get(0);
        lines.forEach(line->{
            if(line.contains(grepWord)){
                result.add(line);
            }
        });
        return result;
    }
}
