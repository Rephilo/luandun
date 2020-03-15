package com.rephilo.luandun.leetcode

import scala.annotation.tailrec

/**
  * LeetCode常规题
  */
object LeetCode {

  /**
    * 074
    *
    * @param nums
    * @param target
    * @return
    */
  def binarySearch(nums: Array[Int], target: Int): Int = {
    @tailrec
    def binarySearchRec(start: Int, end: Int): Int = {
      val mid = (start + end) / 2
      if (start > end) {
        return -1
      }
      if (nums(mid) == target) {
        mid
      } else if (nums(mid) < target) {
        binarySearchRec(mid + 1, end)
      } else {
        binarySearchRec(start, mid - 1)
      }
    }

    binarySearchRec(0, nums.length - 1)
  }

  /**
    * 1342
    *
    * @param num
    * @return
    */
  def numberOfSteps(num: Int): Int = {
    @tailrec
    def steps(num: Int, count: Int): Int = {
      num match {
        case 0 => count
        case odd if num % 2 != 0 => steps(num - 1, count + 1)
        case even if num % 2 == 0 => steps(num / 2, count + 1)
      }
    }

    steps(num, 0)
  }
}
