package com.yxh.question4.impl;

import com.yxh.core.enums.QunarHomeWorkExceptionEnum;
import com.yxh.core.exception.QunarHomeWorkException;
import com.yxh.core.util.FileUtil;
import com.yxh.question4.ShellService;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author yxh
 * @description
 * @time 2022/7/6 10:29
 */
public class CatShellServiceImpl implements ShellService {
    @Override
    public List<String> run(List<String> parms,File file) throws IOException {
        return FileUtil.getContentLines(file);
    }

    @Override
    public List<String> runWithPipe(List<String> parms,List<String> lines) {
        throw new QunarHomeWorkException(QunarHomeWorkExceptionEnum.NOT_SUPPORT_PIPE);
    }
}
