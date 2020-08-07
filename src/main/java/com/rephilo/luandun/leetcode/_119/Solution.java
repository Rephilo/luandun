package com.rephilo.luandun.leetcode._119;

import java.util.ArrayList;
import java.util.List;

/**
 * 119
 *
 * @author rephilo
 */
public class Solution {
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (rowIndex > 0) {
            for (int i = 0; i < rowIndex + 1; i++) {
                triangle.add(new ArrayList<>());
            }

            triangle.get(0).add(1);

            for (int i = 1; i < rowIndex + 1; i++) {
                triangle.get(i).add(1);

                for (int j = 1; j < i; j++) {
                    triangle.get(i).add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }

                triangle.get(i).add(1);
            }
        } else {
            return new ArrayList<Integer>() {
                {
                    add(1);
                }
            };
        }

        return triangle.get(rowIndex);
    }
}
