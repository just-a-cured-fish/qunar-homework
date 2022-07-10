package com.yxh.question4;

import com.google.common.collect.Lists;
import com.yxh.question3.DecodeMain;
import com.yxh.question3.OrderService;
import com.yxh.question3.impl.CharOrderDescServiceImpl;
import com.yxh.question3.impl.CharOrderServiceImpl;
import com.yxh.question3.impl.IndexOrderServiceImpl;
import com.yxh.question3.impl.NatureOrderServiceImpl;
import com.yxh.question4.impl.CatShellServiceImpl;
import com.yxh.question4.impl.GrepShellServiceImpl;
import com.yxh.question4.impl.WcShellSeriveImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yxh
 * @description
 * @time 2022/7/6 11:02
 */
public class ShellFactory {
    private Map<String, ShellService> serviceMap;


    public ShellFactory() {
        //渠道类型为 key , 对应的服务类为value ：
        serviceMap = new HashMap<String, ShellService>();
        serviceMap.put("cat", new CatShellServiceImpl());
        serviceMap.put("wc", new WcShellSeriveImpl());
        serviceMap.put("grep",new GrepShellServiceImpl());
    }

    //根据渠道类型构建短信渠道Service
    public ShellService buildService(String channelType) {
        return serviceMap.get(channelType);
    }
}
