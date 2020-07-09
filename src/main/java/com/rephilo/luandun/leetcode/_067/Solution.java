package com.rephilo.luandun.leetcode._067;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 067
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 转成数字，相加，然后再转回字符串
     * 会溢出，但也算个方法
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary0(String a, String b) {
        return Long.toBinaryString(Long.parseLong(a, 2) + Long.parseLong(b, 2));
    }

    /**
     * 末位相加，放入list然后输出，调整了一下，好看多了
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary1(String a, String b) {
        int l = Math.max(a.length(), b.length());
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= l; i++) {
            int currA = 0;
            if (a.length() - i >= 0) {
                currA = a.charAt(a.length() - i) - '0';
            }

            int currB = 0;
            if (b.length() - i >= 0) {
                currB = b.charAt(b.length() - i) - '0';
            }

            int currResult = currA + currB + carry;
            carry = currResult / 2;

            builder.append(currResult % 2);
        }

        if (carry > 0) {
            builder.append(carry);
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        addBinary1("11", "1");
    }

    /**
     * 官方题解，没太看懂，不过应该和我写的差不多
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }

    /**
     * 这种更清晰一点，容易理解
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary2(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        //循环相加两个字符串相同长度的低位数部分
        while (i >= 0 && j >= 0) {
            int sum = carry;
            sum += a.charAt(i--) - '0';
            sum += b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        // 如果 a 还没遍历完成（a串比b串长），则继续遍历添加 a 的剩余部分
        while (i >= 0) {
            int sum = carry + a.charAt(i--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        // 如果 b 还没遍历完成（b串比a串长），则继续遍历添加 b 的剩余部分
        while (j >= 0) {
            int sum = carry + b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        //如果 carry 不等于0 还有个进位数没加进去，需要补充
        if (carry == 1) {
            builder.append(carry);
        }
        //反转字符串获得正常结果
        return builder.reverse().toString();
    }
}
