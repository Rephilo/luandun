package com.rephilo.luandun.model.datastructure.forwardlist;

import lombok.Data;

/**
 * 链表节点
 *
 * @author rephilo
 */
@Data
public class Snode {
    /**
     * 当前节点数据
     */
    private int data;
    /**
     * 下个节点
     */
    private Snode next;



    public Snode(int data, Snode next) {
        this.data = data;
        this.next = next;
    }
}
