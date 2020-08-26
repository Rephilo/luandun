package com.rephilo.luandun.leetcode._172;

import java.math.BigInteger;

/**
 * 172
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 求一个阶乘的结果最后有几个0
     * 暴力法直接超时了- -
     *
     * @param n
     * @return
     */
    public static int trailingZeroes0(int n) {
        int res = 0;
        if (n > 0) {
            BigInteger factorial = BigInteger.ONE;
            while (n > 1) {
                factorial = factorial.multiply(BigInteger.valueOf(n));
                n = n - 1;
            }

            String s = factorial.toString();
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '0') {
                    res++;
                } else {
                    break;
                }
            }
        }

        return res;
    }

    /**
     * 天秀解法，数一下出现了多少个5
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
