package com.yxh.question2;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.yxh.core.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author yxh
 * @description
 * @time 2022/7/2 10:29
 */
public class AvailableCodeMain {
    private final static String STRING_UTIL_PATH = "/Question 2/StringUtils.java";

    private final static String OUTPUT_PATH = "/Question 2/validLineCount.txt";

    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtil.getContentLines(new File(FileUtil.getResourceFilePath(STRING_UTIL_PATH)));
        Integer counts = CodeCountChain.parse(lines);
        File toWriteFile = new File((FileUtil.getResourceFilePath(OUTPUT_PATH)));
        if (!toWriteFile.exists()) {
            toWriteFile.createNewFile();
        }
        Files.write(String.valueOf(counts), toWriteFile, Charsets.UTF_8);
        System.out.println("统计有效代码行数完毕！");

    }
}
