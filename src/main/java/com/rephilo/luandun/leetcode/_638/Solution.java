package com.rephilo.luandun.leetcode._638;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int originPrice = 0;
        int minPrice = 0;
        //计算原本需要的价格
        for (int i = 0; i < needs.size(); i++) {
            originPrice += needs.get(i) * price.get(i);
        }
        minPrice = originPrice;

        if (special == null || special.isEmpty()) {

        }

        return minPrice;
    }

    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(2, 3, 4);
        List<Integer> needs = Arrays.asList(1, 2, 1);
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(1, 1, 0, 4));
        special.add(Arrays.asList(2, 2, 1, 9));
        int i = shoppingOffers(price, special, needs);
        System.out.println(i);
    }
}
