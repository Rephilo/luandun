package com.rephilo.luandun.scala.leetcode._053

import scala.annotation.tailrec

class Solution {
  /**
    * 053
    *
    * @param nums
    * @return
    */
  def maxSubArray(nums: Array[Int]): Int = {
    @tailrec
    def calcMax(nums: Array[Int], i: Int, max: Int): Int = {
      i match {
        case _ if i == nums.length => max
        case _ =>
          if (nums(i - 1) > 0) {
            nums(i) += nums(i - 1)
          }

          calcMax(nums, i + 1, math.max(nums(i), max))
      }
    }

    calcMax(nums, 1, nums(0))
  }
}
