package com.rephilo.luandun.model.datastructure.stack;

import lombok.Getter;
import lombok.Setter;

/**
 * 迷宫问题状态类
 *
 * @author rephilo
 */
@Getter
@Setter
public class MazeStatus {
    /**
     * 横坐标
     */
    private Integer x;
    /**
     * 纵坐标
     */
    private Integer y;
    /**
     * 方向，以direction取值0, 1, 2, 3标记东南西北.
     */
    private Integer direction;

    public MazeStatus(Integer x, Integer y, Integer direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public MazeStatus() {
    }
}
