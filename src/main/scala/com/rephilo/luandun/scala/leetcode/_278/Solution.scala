package com.rephilo.luandun.scala.leetcode._278

object Solution {
  /**
    * 278
    *
    * @param n
    * @return
    */
  def firstBadVersion(n: Int): Int = {
    val left = 1
    val right = n

    @scala.annotation.tailrec
    def calc(left: Int, right: Int): Int = {
      if (left >= right) {
        return left
      } else {
        val mid = left + (right - left) / 2
        if (isBadVersion(mid)) {
          calc(left, mid)
        } else {
          calc(mid + 1, right)
        }
      }
    }

    def isBadVersion(n: Int): Boolean = {
      return false
    }

    calc(left, right)
  }
}
