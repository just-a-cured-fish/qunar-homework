package com.yxh.question3;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import com.yxh.core.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author yxh
 * @description
 * @time 2022/7/2 15:35
 */
public class DecodeMain {
    private final static String SDXL_PROP = "/Question3/sdxl_prop.txt";
    private final static String SDXL_TEMPLATE = "/Question3/sdxl_template.txt";

    private final static String SDXL_OUTPUT = "/Question3/sdxl.txt";

    public static final String TEMPLATE_FUNCTION_MARKER = "$";

    public static final String TEMPLATE_SUFFIX_MARKER = ")";

    public static final String TEMPLATE_PRE_MARKER = "(";

    public static void main(String[] args) throws IOException {
        LinkedHashMap<String, String> indexOrderMap = Files.readLines(new File(Resources.getResource(SDXL_PROP).getFile()), Charsets.UTF_8, new IndexOrderLineProcessor());
        List<String> lists = Files.readLines(new File(FileUtil.getResourceFilePath(SDXL_PROP)), Charsets.UTF_8, new LineParseProcessor());
        OrderChannelFactory orderChannelFactory = new OrderChannelFactory(lists, indexOrderMap);
        List<String> lines = Files.readLines(new File(FileUtil.getResourceFilePath(SDXL_TEMPLATE)), Charsets.UTF_8);

        List<String> result = Lists.newArrayList();
        lines.forEach(line -> {
            int placeholderMarker = line.indexOf(TEMPLATE_FUNCTION_MARKER);
            if (placeholderMarker != -1) {
                int placeholderSuffix = line.indexOf(TEMPLATE_SUFFIX_MARKER, placeholderMarker);
                //解析出解密需调用的方法名
                String functionName = line.substring(placeholderMarker, placeholderSuffix + 1);
                //根据解密方法名字去调用
                String replaceMent = orderChannelFactory.buildService(functionName).order(line);
                line = line.replace(functionName, replaceMent);
            }
            result.add(line);

        });
        //输出到文件中
        File file = new File(FileUtil.getResourceFilePath(SDXL_OUTPUT));
        Files.asCharSink(file, Charsets.UTF_8).writeLines(result);

    }
}
