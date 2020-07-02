package com.rephilo.luandun.scala.leetcode._035

import scala.annotation.tailrec

/**
  * 035
  *
  * @author rephilo
  */
object Solution {

  /**
    * 循环
    *
    * @param nums
    * @param target
    * @return
    */
  def searchInsert1(nums: Array[Int], target: Int): Int = {
    for (i <- nums.indices) {
      if (nums(i) >= target) {
        return i
      }
    }

    nums.length
  }

  /**
    * 二分法
    *
    * @param nums
    * @param target
    * @return
    */
  def searchInsert2(nums: Array[Int], target: Int): Int = {

    @tailrec
    def binarySearch(left: Int, right: Int, nums: Array[Int], target: Int): Int = {
      val mid = left + (right - left) / 2
      if (left < right) {
        left
      } else {
        if (nums(mid) < target) {
          binarySearch(mid + 1, right, nums, target)
        } else {
          binarySearch(left, mid, nums, target)
        }
      }
    }

    binarySearch(0, nums.length, nums, target)
  }
}
