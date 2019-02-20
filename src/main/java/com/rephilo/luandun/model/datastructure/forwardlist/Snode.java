package com.rephilo.luandun.model.datastructure.forwardlist;

/**
 * 链表节点
 *
 * @author rephilo
 */
public class Snode {
    /**
     * 当前节点数据
     */
    private int data;
    /**
     * 下个节点
     */
    private Snode next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Snode getNext() {
        return next;
    }

    public void setNext(Snode next) {
        this.next = next;
    }

    public Snode(int data, Snode next) {
        this.data = data;
        this.next = next;
    }

    public Snode() {
    }
}
