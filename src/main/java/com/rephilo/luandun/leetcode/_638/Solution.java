package com.rephilo.luandun.leetcode._638;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static Map<List<Integer>, Integer> cache = new HashMap<>();
    static int a = 0;

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int originPrice = 0;
        int minPrice = 0;
        //计算原本需要的价格
        for (int i = 0; i < needs.size(); i++) {
            originPrice += needs.get(i) * price.get(i);
        }
        minPrice = originPrice;

        //过滤不可用折扣
        List<List<Integer>> filteredSpecial = getFilteredSpecial(price, special, needs);

        if (!filteredSpecial.isEmpty()) {
            minPrice = doShoppingOffers(price, filteredSpecial, needs);
        }

        return minPrice;
    }

    /**
     * 过滤不可用的折扣
     *
     * @param price
     * @param special
     * @param needs
     * @return
     */
    private static List<List<Integer>> getFilteredSpecial(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        List<List<Integer>> filteredSpecial = new ArrayList<>();
        for (List<Integer> currSpecial : special) {
            int tmpPrice = 0;
            boolean moreThanNeed = false;
            for (int i = 0; i < needs.size(); i++) {
                if (currSpecial.get(i) > needs.get(i)) {
                    moreThanNeed = true;
                }
                tmpPrice += currSpecial.get(i) * price.get(i);
            }
            //不能多买，并且没有打包费
            if (!moreThanNeed && tmpPrice >= currSpecial.get(needs.size())) {
                filteredSpecial.add(currSpecial);
            }
        }
        return filteredSpecial;
    }

    /**
     * 查找可用折扣的最小金额
     *
     * @param price
     * @param filteredSpecial
     * @param needs
     * @return
     */
    private static int doShoppingOffers(List<Integer> price, List<List<Integer>> filteredSpecial, List<Integer> needs) {
        Integer minPrice = cache.get(needs);
        if (minPrice == null) {
            System.out.println(++a);
            System.out.println(needs + "?" + filteredSpecial);
            minPrice = 0;
            for (int i = 0; i < needs.size(); i++) {
                minPrice += needs.get(i) * price.get(i);
            }

            for (List<Integer> currSpecial : filteredSpecial) {
                int specialPrice = currSpecial.get(needs.size());
                List<Integer> nextNeeds = new ArrayList<>();
                for (int i = 0; i < needs.size(); i++) {
                    if (currSpecial.get(i) > needs.get(i)) {
                        break;
                    }

                    nextNeeds.add(needs.get(i) - currSpecial.get(i));
                }

                if (nextNeeds.size() == needs.size()) {
                    minPrice = Math.min(minPrice, doShoppingOffers(price, filteredSpecial, nextNeeds) + specialPrice);
                }
            }

            cache.put(needs, minPrice);
        }
        return minPrice;
    }

    public static void main(String[] args) {
        List<Integer> price = Arrays.asList(10, 1, 1, 3, 8, 3);
        List<Integer> needs = Arrays.asList(3, 6, 1, 4, 5, 4);
        List<List<Integer>> special;
        String speStr = " [[0,5,6,5,6,0,14],[6,3,2,1,2,0,11],[3,5,3,3,6,6,12],[0,3,0,6,6,1,25],[4,5,3,2,3,2,15],[2,0,1,6,2,4,2],[4,2,4,5,5,5,22],[3,2,6,3,5,4,9],[4,6,4,6,2,5,1],[3,0,0,6,6,2,18],[1,4,2,3,4,4,1],[3,2,6,6,4,4,2],[1,1,0,5,5,2,15],[0,1,5,4,6,5,7],[3,5,2,4,0,5,20],[3,0,3,6,3,2,3],[5,4,1,6,6,1,7],[2,1,6,1,2,2,8],[0,5,4,3,4,4,4],[2,0,2,5,1,5,7],[4,6,5,0,3,4,19],[0,5,6,3,0,5,8],[0,5,0,0,3,4,15],[5,6,1,1,0,3,15],[1,2,0,3,1,5,12],[2,1,6,3,6,3,7],[4,6,3,3,4,3,3],[1,5,5,6,4,6,19],[4,1,5,3,3,5,25],[2,1,6,4,2,3,7],[0,0,6,2,6,0,7],[4,3,0,3,6,3,5],[4,1,1,6,2,6,10],[5,2,5,5,1,4,8],[4,1,1,2,6,0,20],[5,6,3,0,2,1,12],[2,4,4,4,5,5,11],[0,2,2,3,2,1,13],[3,3,2,5,4,3,24],[3,1,3,0,0,4,20],[3,5,2,3,2,6,1],[6,2,6,4,4,0,24],[6,1,0,2,4,2,18],[0,5,6,1,0,2,20],[0,6,0,1,2,0,16],[5,6,0,2,6,5,7],[3,5,0,0,6,1,25],[1,3,1,6,0,6,3],[0,6,0,0,6,0,23],[1,5,2,4,2,3,18],[1,1,6,4,6,4,4],[3,3,5,2,5,4,21],[5,1,3,5,1,3,8],[0,2,3,6,0,6,3],[3,0,6,4,6,5,23],[3,1,4,6,4,0,24],[0,3,1,5,4,2,8],[5,6,5,3,6,6,3],[6,3,3,0,3,2,8],[0,6,5,3,0,0,10],[2,6,0,3,2,1,2],[6,2,3,5,1,6,2],[5,5,2,4,2,3,7]]";
        special = JSON.parseObject(speStr, new TypeReference<List<List<Integer>>>() {
        });
        int i = shoppingOffers(price, special, needs);
        System.out.println(i);
    }
}
