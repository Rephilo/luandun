package com.rephilo.luandun.leetcode

/**
  * leetcode April challenge
  *
  * @author wangxiao15
  */
object LeetCodeChallenge {
  /**
    * 1st
    * 天秀解法，异或
    *
    * @param nums
    * @return
    */
  def singleNumber(nums: Array[Int]): Int = nums.reduce(_ ^ _)
}
