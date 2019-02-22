package com.rephilo.luandun.model.datastructure.stack;

/**
 * 迷宫问题状态类
 *
 * @author rephilo
 */
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

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public MazeStatus(Integer x, Integer y, Integer direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public MazeStatus() {
    }
}
