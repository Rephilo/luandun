package com.rephilo.luandun.model.vo;

/**
 * 基础时间类
 *
 * @author rephilo
 */
public class BaseTimeVO {
    private Long time;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "BaseTimeVO{" +
                "time=" + time +
                '}';
    }
}
