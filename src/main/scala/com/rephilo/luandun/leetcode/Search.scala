package com.rephilo.luandun.leetcode

import scala.annotation.tailrec


object Search {
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
}
