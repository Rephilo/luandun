package com.rephilo.luandun.leetcode._476

import scala.annotation.tailrec

object Solution {
  /**
    * 476
    * 不知道为啥执行不下去呀
    *
    * @param num
    * @return
    */
  def findComplement(num: Int): Int = {
    @tailrec
    def calc(num: Int, c: Int): Int = {
      num match {
        case _ if (num <= 0) => num ^ c
        case _ => calc(num >> 1, (c << 1) + 1)
      }
    }

    calc(num, 0)
  }
}
