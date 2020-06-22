package com.rephilo.luandun.scala.leetcode._136

object Solution {
  /**
    * 136
    * 天秀解法，异或
    *
    * @param nums
    * @return
    */
  def singleNumber(nums: Array[Int]): Int = nums.reduce(_ ^ _)
}
