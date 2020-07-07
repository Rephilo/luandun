package com.rephilo.luandun.leetcode._066;

/**
 * 066
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 单纯的+1操作，用一个懒方法把数组转换成数字，+1了再转成数组
     * 方法本身没大问题，但是超出了long的长度就不行了，估计没人会像我一样神经病到用这种方法- -
     *
     * @param digits
     * @return
     */
    public static int[] plusOne0(int[] digits) {
        long temp = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            temp = (long) (digits[i] * Math.pow(10, (digits.length - 1 - i))) + temp;
        }

        temp = temp + 1;

        int[] result = new int[(int) Math.log10(temp) + 1];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = (int) (temp % 10);
            temp = temp / 10;
        }

        return result;
    }

    /**
     * for循环先找到最后一个+1，没有进位就能直接返回了
     * 如果遇到9往前找，找到一个不是9的+1，后面都写0就行
     *
     * @param digits
     * @return
     */
    public static int[] plusOne2(int[] digits) {
        int[] result;
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            result = digits;
        } else {
            int index = digits.length - 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] == 9) {
                    index = i - 1;
                } else {
                    break;
                }
            }

            if (index == -1) {
                result = new int[digits.length + 1];
                result[0] = 1;
            } else {
                result = new int[digits.length];
                for (int i = 0; i < index; i++) {
                    result[i] = digits[i];
                }

                result[index] = digits[index] + 1;
            }
        }

        return result;
    }

    /**
     * 自己写的太繁琐了，抄一个
     * 简化版
     *
     * @param digits
     * @return
     */
    public int[] plusOne3(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
