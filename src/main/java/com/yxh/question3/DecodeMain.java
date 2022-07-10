package com.yxh.question3;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.google.common.io.Resources;

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
    private final static String SDXL_PROP = "src/main/resources/doc/attachments/Question3/sdxl_prop.txt";
    private final static String SDXL_TEMPLATE = "src/main/resources/doc/attachments/Question3/sdxl_template.txt";

    public static final String TEMPLATE_FUNCTION_MARKER = "$";

    public static final String TEMPLATE_SUFFIX_MARKER = ")";

    public static final String TEMPLATE_PRE_MARKER = "(";

    public static void main(String[] args) throws IOException {
        LinkedHashMap<String, String> indexOrderMap = Files.readLines(new File(Resources.getResource("doc/attachments/Question3/sdxl_prop.txt").getFile()), Charsets.UTF_8, new IndexOrderLineProcessor());
        List<String> lists = Files.readLines(new File(SDXL_PROP), Charsets.UTF_8, new LineParseProcessor());
        OrderChannelFactory orderChannelFactory = new OrderChannelFactory(lists, indexOrderMap);
        List<String> lines = Files.readLines(new File(SDXL_TEMPLATE), Charsets.UTF_8);

        List<String> result = Lists.newArrayList();
        lines.forEach(line -> {
            int placeholderMarker = line.indexOf(TEMPLATE_FUNCTION_MARKER);
            if (placeholderMarker != -1) {
                int placeholderSuffix = line.indexOf(TEMPLATE_SUFFIX_MARKER, placeholderMarker);
                String functionName = line.substring(placeholderMarker, placeholderSuffix + 1);
                String replaceMent = orderChannelFactory.buildService(functionName).order(line);
                line = line.replace(functionName, replaceMent);
            }
            result.add(line);

        });
        File file = new File("src/main/resources/doc/attachments/Question3/sdxl.txt");

        Files.asCharSink(file, Charsets.UTF_8).writeLines(result);

    }
}
