package com.yxh.question4.impl;

import com.yxh.core.util.FileUtil;
import com.yxh.question4.ShellService;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author yxh
 * @description
 * @time 2022/7/6 10:16
 */
public class WcShellSeriveImpl implements ShellService {
    @Override
    public List<String> run(List<String> parms,File file) throws IOException {
        return Arrays.asList(String.valueOf(FileUtil.getContentLines(file).size()));
    }

    @Override
    public List<String> runWithPipe(List<String> parms,List<String> lines) {
        return Arrays.asList(String.valueOf(lines.size()));
    }
}
