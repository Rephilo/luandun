package com.rephilo.luandun.leetcode._009

import scala.annotation.tailrec

object Solution {
  /**
    * 009
    *
    * @param x
    * @return
    */
  def isPalindrome(x: Int): Boolean = {
    if (x < 0) {
      return false
    }

    @tailrec
    def loop(x: Int, reverse: Int): Int = {
      x match {
        case 0 => reverse
        case _ if x != 0 => loop(x / 10, reverse * 10 + x % 10)
      }
    }

    x == loop(x, 0)
  }
}
