package com.rephilo.luandun.model.param;

import lombok.Data;

/**
 * 生成随机数据集合的参数
 *
 * @author rephilo
 */
@Data
public class RandomParam {
    /**
     * 随机数最小值
     */
    private Integer from = 0;

    /**
     * 随机数最大值
     */
    private Integer to = 100;

    /**
     * 随机数个数
     */
    private Integer size = 100;
}
