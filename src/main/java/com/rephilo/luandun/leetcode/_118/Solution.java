package com.rephilo.luandun.leetcode._118;

import java.util.ArrayList;
import java.util.List;

/**
 * 118
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 杨辉三角，啊呦看着头疼
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows > 0) {
            for (int i = 0; i < numRows; i++) {
                triangle.add(new ArrayList<>());
            }

            triangle.get(0).add(1);


            for (int i = 1; i < numRows; i++) {
                triangle.get(i).add(1);

                for (int j = 1; j < i; j++) {
                    triangle.get(i).add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }

                triangle.get(i).add(1);
            }
        }

        return triangle;
    }
}
