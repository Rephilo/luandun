package com.rephilo.luandun.service.datastructure;

import com.rephilo.luandun.model.datastructure.forwardlist.Snode;
import org.springframework.stereotype.Service;

/**
 * 极简数据结构 第4章
 *
 * @author rephilo
 */
@Service
public class ForwardListService {

    /**
     * 生成单链表
     *
     * @param data 传入数组
     * @return 返回链表头元素
     */
    public Snode getForwardList(int[] data) {
        if (data.length <= 0) {
            return null;
        }

        Snode[] v = new Snode[data.length];
        for (int i = 0; i < v.length; i++) {
            v[i] = new Snode(data[i], null);
        }

        Snode header = v[0];
        for (int i = 1; i < v.length; i++) {
            header.setNext(v[i]);
            header = header.getNext();
        }

        return header;
    }

    /**
     * 链表逆置
     *
     * @param header 链表头元素
     */
    public Snode reverseList(Snode header) {
        Snode prev = null;
        Snode curr = header.getNext();

        while (curr != null) {
            Snode next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }

        header.setNext(prev);

        return header;
    }
}
