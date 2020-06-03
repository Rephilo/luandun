package com.rephilo.luandun.leetcode._122

object Solution {
  /**
    * 122
    * sliding函数（选取的元素数，步长）
    *
    * @param prices
    * @return
    */
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.length < 2) 0 else prices.sliding(2, 1).map(x => x(1) - x(0)).filter(_ > 0).sum
  }
}
