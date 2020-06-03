package com.rephilo.luandun.leetcode._201

import scala.annotation.tailrec

object Solution {
  /**
    * 201
    *
    * @param m
    * @param n
    * @return
    */
  def rangeBitwiseAnd(m: Int, n: Int): Int = {
    @tailrec
    def calc(m: Int, n: Int, step: Int): Int = {
      if (m == n) {
        n << step
      } else {
        calc(m >> 1, n >> 1, step + 1)
      }
    }

    calc(m, n, 0)
  }
}
