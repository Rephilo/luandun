package com.rephilo.luandun.leetcode._168;

/**
 * 168
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 10进制转26进制，使用除留余数法倒序输出
     * 需要注意的是，逻辑上A是1，实际上A在ascii码上是0
     *
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            int x = n % 26;
            sb.append((char) (x + 'A'));
            n = n / 26;
        }
        return sb.reverse().toString();
    }
}
