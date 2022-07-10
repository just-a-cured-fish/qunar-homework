package com.yxh.question3;

import com.google.common.collect.Lists;
import com.yxh.question3.impl.CharOrderDescServiceImpl;
import com.yxh.question3.impl.CharOrderServiceImpl;
import com.yxh.question3.impl.IndexOrderServiceImpl;
import com.yxh.question3.impl.NatureOrderServiceImpl;
import sun.security.util.ArrayUtil;

import java.util.*;

/**
 * @author yxh
 * @description
 * @time 2022/7/2 17:16
 */
public class OrderChannelFactory {
    private Map<String, OrderService> serviceMap;


    public OrderChannelFactory(List<String> lines, LinkedHashMap<String, String> map) {
        //渠道类型为 key , 对应的服务类为value ：
        serviceMap = new HashMap<String, OrderService>();
        serviceMap.put("$natureOrder", new NatureOrderServiceImpl(Lists.newArrayList(lines)));
        serviceMap.put("$indexOrder", new IndexOrderServiceImpl(Lists.newArrayList(lines), map));
        serviceMap.put("$charOrder", new CharOrderServiceImpl(Lists.newArrayList(lines)));
        serviceMap.put("$charOrderDESC", new CharOrderDescServiceImpl(Lists.newArrayList(lines)));
    }

    //根据渠道类型构建短信渠道Service
    public OrderService buildService(String channelType) {
        channelType=channelType.substring(channelType.indexOf(DecodeMain.TEMPLATE_FUNCTION_MARKER),channelType.indexOf(DecodeMain.TEMPLATE_PRE_MARKER));
        return serviceMap.get(channelType);
    }
}
