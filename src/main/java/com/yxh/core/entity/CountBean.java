package com.yxh.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yxh
 * @description
 * @time 2022/7/10 16:29
 */
@Data
@AllArgsConstructor
public class CountBean {
    /**
     * 当前方法统计出的此类别代码行数
     */
    private Integer count;
    /**
     * 统计中的索引位置
     */
    private Integer index;
}
