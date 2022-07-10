package com.yxh.question1;

import com.google.common.base.Splitter;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.yxh.core.entity.UrlBean;
import com.yxh.core.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author yxh
 * @description
 * @time 2022/6/29 21:40
 */
public class question1 {
    private final static String ACCESS_LOG_PATH = "/Question 1/access.log";

    public static void main(String[] args) {
        try {

            List<String> readLines = FileUtil.getContentLines(new File(FileUtil.getResourceFilePath(ACCESS_LOG_PATH)));
            System.out.printf("请求总量为" + readLines.size());

            getTenMostReq(readLines);

            countPostAndGet(readLines);

            countReqType(readLines);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 分组不同类型请求
     *
     * @param readLines
     */
    private static void countReqType(List<String> readLines) {
        //4、URI 格式均为 /AAA/BBB 或者 /AAA/BBB/CCC 格式，按 AAA 分类，输出各个类别下 URI 都有哪些
        Multimap<String, String> typeOfUrlMap = HashMultimap.create();
        for (String url : readLines) {
            String key = Splitter.on("/")
                    .trimResults()
                    .omitEmptyStrings()
                    .splitToList(url).get(1);
            String value = Splitter.on("?")
                    .trimResults()
                    .omitEmptyStrings()
                    .splitToList(url.split(" ")[1]).get(0);
            typeOfUrlMap.put(key, value);
        }
        for (String key : typeOfUrlMap.keySet()) {
            System.out.println("===================分割线============================");
            System.out.println("类别为'/" + key + "'的URI有以下这些:");
            for (String uri : typeOfUrlMap.get(key)) {
                System.out.println(uri);
            }
        }
    }

    /**
     * 统计Post和Get的请求量
     *
     * @param readLines
     */
    private static void countPostAndGet(List<String> readLines) {
        //3、POST 和 GET 请求量分别为多少
        Multiset<String> requestTypeMap = HashMultiset.create();
        readLines.stream().forEach(item -> {
            if (item.startsWith("GET")) {
                requestTypeMap.add("GET");
            } else if (item.startsWith("POST")) {
                requestTypeMap.add("POST");
            }
        });
        System.out.println("POST请求数量为： " + requestTypeMap.count("GET"));
        System.out.println("GET请求数量为： " + requestTypeMap.count("POST"));
    }

    public static Comparator<UrlBean> urlBeanComparator = new Comparator<UrlBean>() {

        @Override
        public int compare(UrlBean o1, UrlBean o2) {
            return o2.getCount() - o1.getCount();
        }

    };

    /**
     * 获取十个最多访问的接口
     *
     * @param readLines
     */
    public static void getTenMostReq(List<String> readLines) {
        Queue<UrlBean> urlBeanPriorityQueue = new PriorityQueue<UrlBean>(10, urlBeanComparator);
        Multiset<String> urlMap = HashMultiset.create();
        for (String tmp : readLines) {
            urlMap.add(tmp);
        }
        Iterator<Multiset.Entry<String>> iterator = urlMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Multiset.Entry<String> entry = iterator.next();
            urlBeanPriorityQueue.add(new UrlBean(entry.getElement(), entry.getCount()));
        }
        System.out.println("请求最频繁的10个HTTP接口为：");
        for (int i = 0; i < 10; i++) {
            System.out.println(urlBeanPriorityQueue.poll().toString());
        }
    }


}
