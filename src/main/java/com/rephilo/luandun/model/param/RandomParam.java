package com.rephilo.luandun.model.param;

/**
 * 生成随机数据集合的参数
 *
 * @author rephilo
 */
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

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
