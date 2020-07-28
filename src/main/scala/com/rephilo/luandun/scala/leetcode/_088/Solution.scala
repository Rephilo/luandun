package com.rephilo.luandun.scala.leetcode._088

/**
  * 088
  *
  * @author rephilo
  */
object Solution {
  /**
    * 终于碰上一道能写出来的scala题了。。。
    *
    * @param nums1
    * @param m
    * @param nums2
    * @param n
    */
  def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
    val tmp = Array.concat(nums1.take(m), nums2.take(n)).sorted
    Array.copy(tmp, 0, nums1, 0, nums1.length)
  }
}
