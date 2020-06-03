package com.rephilo.luandun.leetcode._1108;

public class Solution {
    /**
     * 1108
     *
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
