package com.yxh.question4;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author yxh
 * @description
 * @time 2022/7/6 10:08
 */
public interface ShellService {

    List<String> run(List<String> parms,File file) throws IOException;

    List<String> runWithPipe(List<String> parms,List<String> lines);
}
