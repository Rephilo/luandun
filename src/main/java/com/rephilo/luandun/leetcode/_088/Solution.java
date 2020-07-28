package com.rephilo.luandun.leetcode._088;

import java.util.Arrays;

/**
 * 088
 *
 * @author rephilo
 */
public class Solution {
    /**
     * 把nums2挂到nums1后面然后整体排个序，秀
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 当成归并排序来做，申请个长度m的数组，然后把num1抄过来，然后做合并
     * 写不到官方那么简洁，老老实实写if else
     * 时间复杂度O(m+n)，空间复杂度O(m)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1copy = new int[m];
        System.arraycopy(nums1, 0, nums1copy, 0, m);

        int i = 0;
        int j = 0;
        int curr = 0;
        while (i < m || j < n) {
            int currNum = 0;
            if (i >= m) {
                currNum = nums2[j];
                j++;
            } else if (j >= n) {
                currNum = nums1copy[i];
                i++;
            } else if (nums1copy[i] < nums2[j]) {
                currNum = nums1copy[i];
                i++;
            } else {
                currNum = nums2[j];
                j++;
            }
            nums1[curr] = currNum;
            curr++;
        }
    }

    /**
     * 从数组尾开始，倒序合并，就不用申请nums1的copy数组了
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int curr = m + n - 1;
        while (i >= 0 || j >= 0) {
            int currNum = 0;
            if (i < 0) {
                currNum = nums2[j];
                j--;
            } else if (j < 0) {
                currNum = nums1[i];
                i--;
            } else if (nums1[i] > nums2[j]) {
                currNum = nums1[i];
                i--;
            } else {
                currNum = nums2[j];
                j--;
            }
            nums1[curr] = currNum;
            curr--;
        }
    }

    /**
     * 留一份官方方案
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int p1 = 0;
        int p2 = 0;
        int p = 0;

        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }

        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }
}
