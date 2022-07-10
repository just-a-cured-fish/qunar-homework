package com.yxh.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yxh
 * @description
 * @time 2022/7/10 18:53
 */
@Data
@AllArgsConstructor
public class UrlBean {
    private String url;

    private Integer count;

    @Override
    public String toString() {
        return url + '\'' +
                "  请求数量为" + count;
    }
}
