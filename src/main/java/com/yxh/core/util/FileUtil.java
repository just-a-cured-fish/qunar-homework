package com.yxh.core.util;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author yxh
 * @description
 * @time 2022/7/6 10:18
 */
public class FileUtil {
    private final static String RESOURCE_PATH = "src/main/resources/doc/attachments";

    public static List<String> getContentLines(File file) throws IOException {
        return Files.readLines(file, Charsets.UTF_8);
    }

    public static String getResourceFilePath(String fileName) {
        return RESOURCE_PATH + fileName;

    }
}
