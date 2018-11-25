package com.rephilo.luandun.model.vo;

import java.util.List;

/**
 * 排序结果VO
 *
 * @author rephilo
 */
public class SortResultVO extends BaseTimeVO {

    private int[] result;

    public int[] getResult() {
        return result;
    }

    public void setResult(int[] result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SortResultVO{" +
                "result=" + result +
                '}';
    }
}
