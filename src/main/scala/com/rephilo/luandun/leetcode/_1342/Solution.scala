package com.rephilo.luandun.leetcode._1342

import scala.annotation.tailrec

object Solution {
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
        case _ if num % 2 != 0 => steps(num - 1, count + 1)
        case _ if num % 2 == 0 => steps(num / 2, count + 1)
      }
    }

    steps(num, 0)
  }
}
